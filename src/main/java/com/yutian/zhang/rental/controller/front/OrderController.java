package com.yutian.zhang.rental.controller.front;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.enums.HouseStatusEnum;
import com.yutian.zhang.rental.common.enums.OrderStatusEnum;
import com.yutian.zhang.rental.common.util.DateUtil;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.entity.Order;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.HouseService;
import com.yutian.zhang.rental.service.OrderService;
import com.yutian.zhang.rental.service.UserService;
import com.yutian.zhang.rental.common.dto.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Order Controller
 *
 * @author Yutian Zhang
 * @date 27/01/2022 13:49
 */

@Controller("orderController")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private UserService userService;

    /**
     * Create order
     *
     * @param houseId
     * @param endDateStr
     * @return
     */
    @RequestMapping("/order/create")
    @ResponseBody
    public JsonResult createOrder(@RequestParam("houseId") Long houseId,
                                  @RequestParam("startDate") String startDateStr,
                                  @RequestParam("endDate") String endDateStr) {
        House house = houseService.get(houseId);
        if (house == null) {
            return JsonResult.error("house does not exist");
        }
        if (Objects.equals(house.getStatus(), HouseStatusEnum.HAS_RENT.getValue())) {
            return JsonResult.error("House is rented out or not released");
        }


        Order checkOrder = orderService.getCurrentEffectiveOrder(houseId);
        if (checkOrder != null) {
            return JsonResult.error("House is rented out or not released");
        }
        User ownerUser = userService.get(house.getUserId());
        if (ownerUser == null) {
            return JsonResult.error("Landlord user does not exist");
        }


        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate;
        Date endDate;
        try {
            startDate = sdf.parse(startDateStr);
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return JsonResult.error("Failed to return the rental");
        }

        Integer dayNum = DateUtil.daysBetween(startDate, endDate);

        if (getLoginUserId() == null) {
            return JsonResult.error("Please Login First!");
        }


        Order order = new Order();
        order.setHouseId(houseId);
        order.setCustomerUserId(getLoginUserId());
        order.setOwnerUserId(ownerUser.getId());
        order.setMonthRent(house.getMonthRent());
        order.setDayNum(dayNum);
        order.setTotalAmount(house.getMonthRent() / 30 * dayNum);
        order.setStatus(OrderStatusEnum.NOT_AGREEMENT.getValue());
        order.setStartDate(startDate);
        order.setEndDate(endDate);
        order.setCreateTime(new Date());
        orderService.insert(order);
        return JsonResult.success("Order created successfully, please sign the agreement", order.getId());
    }

    /**
     * viewAgreement
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/order/agreement/view")
    public String viewAgreement(@RequestParam(value = "orderId") Long orderId,
                                Model model) {

        Order order = orderService.get(orderId);
        if (order == null) {
            return this.renderNotFound();
        }
        Long loginUserId = getLoginUserId();
        if (!Objects.equals(loginUserId, order.getCustomerUserId()) &&
                !Objects.equals(loginUserId, order.getOwnerUserId()) &&
                !loginUserIsAdmin()) {
            return this.renderNotAllowAccess();
        }
        order.setHouse(houseService.get(order.getHouseId()));

        order.setCustomerUser(userService.get(order.getCustomerUserId()));

        order.setOwnerUser(userService.get(order.getOwnerUserId()));

        model.addAttribute("order", order);
        return "front/agreement";
    }

    /**
     * Payment page
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/order/pay")
    public String pay(@RequestParam(value = "orderId") Long orderId,
                      Model model) {

        Order order = orderService.get(orderId);
        if (order == null) {
            return this.renderNotFound();
        }

        Long loginUserId = getLoginUserId();
        if (!Objects.equals(loginUserId, order.getCustomerUserId()) &&
                !Objects.equals(loginUserId, order.getOwnerUserId()) &&
                !loginUserIsAdmin()) {
            return this.renderNotAllowAccess();
        }

        House house = houseService.get(order.getHouseId());
        if (house == null) {
            return this.renderNotFound();
        }
        order.setHouse(house);
        model.addAttribute("order", order);
        return "front/pay";
    }


    /**
     * Agreement submit
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/order/agreement/submit")
    @ResponseBody
    public JsonResult submitAgreement(@RequestParam("orderId") Long orderId) {
        // 校验

        Order order = orderService.get(orderId);
        if (order == null) {
            return JsonResult.error("Order do not exist");
        }

        Long loginUserId = getLoginUserId();
        if (!Objects.equals(loginUserId, order.getCustomerUserId()) &&
                !Objects.equals(loginUserId, order.getOwnerUserId()) &&
                !loginUserIsAdmin()) {
            return JsonResult.error("No permission");
        }

        House house = houseService.get(order.getHouseId());
        if (house == null) {
            return JsonResult.error("house does not exist");
        }
        if (Objects.equals(house.getStatus(), HouseStatusEnum.HAS_RENT.getValue())) {
            return JsonResult.error("House is rented out or not released");
        }
        Order checkOrder = orderService.getCurrentEffectiveOrder(house.getId());
        if (checkOrder != null) {
            return JsonResult.error("House is rented out or not released");
        }

        order.setStatus(OrderStatusEnum.NOT_PAY.getValue());
        orderService.update(order);
        return JsonResult.success("Agreement signed successfully, please pay for the order", order.getId());
    }



    /**
     * Order payment
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/order/pay/submit")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult createOrder(@RequestParam("orderId") Long orderId) {

        Order order = orderService.get(orderId);
        if (order == null) {
            return JsonResult.error("Order do not exist");
        }

        Long loginUserId = getLoginUserId();
        if (!Objects.equals(loginUserId, order.getCustomerUserId()) &&
                !Objects.equals(loginUserId, order.getOwnerUserId()) &&
                !loginUserIsAdmin()) {
            return JsonResult.error("No permission");
        }

        House house = houseService.get(order.getHouseId());
        if (house == null) {
            return JsonResult.error("house does not exist");
        }
        if (Objects.equals(house.getStatus(), HouseStatusEnum.HAS_RENT.getValue())) {
            return JsonResult.error("House is rented out or not released");
        }
        Order checkOrder = orderService.getCurrentEffectiveOrder(house.getId());
        if (checkOrder != null) {
            return JsonResult.error("House is rented out or not released");
        }

        order.setStatus(OrderStatusEnum.NORMAL.getValue());
        orderService.update(order);

        house.setStatus(HouseStatusEnum.HAS_RENT.getValue());
        house.setLastOrderStartTime(order.getStartDate());
        house.setLastOrderEndTime(order.getEndDate());
        houseService.update(house);
        return JsonResult.success("Payment success");
    }

}
