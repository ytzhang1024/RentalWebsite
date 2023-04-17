package com.yutian.zhang.rental.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.enums.HouseStatusEnum;
import com.yutian.zhang.rental.common.enums.OrderStatusEnum;
import com.yutian.zhang.rental.common.util.DateUtil;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.entity.Order;
import com.yutian.zhang.rental.service.HouseService;
import com.yutian.zhang.rental.service.OrderService;
import com.yutian.zhang.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Objects;

/**
 * Order Controller
 *
 * @author Yutian Zhang
 * @date 27/01/2022 16:34
 */
@Controller("backOrderController")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private UserService userService;


    /**
     * Order list
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/order")
    public String allOrder(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                           @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                           Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        Order condition = new Order();
        // Enquiry user order
        if (loginUserIsCustomer()) {
            condition.setCustomerUserId(getLoginUserId());
        }
        // Enquiry landlord order
        else if (loginUserIsOwner()) {
            condition.setOwnerUserId(getLoginUserId());
        }
        //Administrator can access all orders
        Page<Order> orderPage = orderService.findAll(page, condition);
        for (Order order : orderPage.getRecords()) {
            order.setHouse(houseService.get(order.getHouseId()));
            order.setOwnerUser(userService.get(order.getOwnerUserId()));
            order.setCustomerUser(userService.get(order.getCustomerUserId()));
        }
        model.addAttribute("pageInfo", orderPage);

        model.addAttribute("tab", "order-list");
        model.addAttribute("pagePrefix", "/admin/order?");
        return "admin/order-list";
    }


    /**
     * Cancel order
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/admin/order/cancel", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult cancelOrder(@RequestParam("orderId") Long orderId) {
        Order order = orderService.get(orderId);
        if (order == null) {
            return JsonResult.error("Order does not exist");
        }
        Long loginUserId = getLoginUserId();
        if (!Objects.equals(loginUserId, order.getCustomerUserId()) &&
                !Objects.equals(loginUserId, order.getOwnerUserId()) &&
                !loginUserIsAdmin()) {
            return JsonResult.error("No permission");
        }

        order.setStatus(OrderStatusEnum.CUSTOMER_CANCEL.getValue());
        orderService.update(order);
        return JsonResult.success("Cancel success");
    }


    /**
     * Early surrender application
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/admin/order/end", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult endOrder(@RequestParam("orderId") Long orderId) {
        Order order = orderService.get(orderId);
        if (order == null) {
            return JsonResult.error("Order does not exist");
        }
        Long loginUserId = getLoginUserId();
        if (!Objects.equals(loginUserId, order.getCustomerUserId()) &&
                !Objects.equals(loginUserId, order.getOwnerUserId()) &&
                !loginUserIsAdmin()) {
            return JsonResult.error("No permission");
        }

        order.setStatus(OrderStatusEnum.END_APPLY.getValue());
        orderService.update(order);
        return JsonResult.success("Rent refund have applied, awaiting review by landlord");
    }


    /**
     * Agree to refund
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/admin/order/endPass", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult endPass(@RequestParam("orderId") Long orderId) {

        Order order = orderService.get(orderId);
        if (order == null) {
            return JsonResult.error("Order does not exist");
        }

        Long loginUserId = getLoginUserId();
        if (!Objects.equals(loginUserId, order.getOwnerUserId()) &&
                !loginUserIsAdmin()) {
            return JsonResult.error("No permission");
        }

        order.setStatus(OrderStatusEnum.FINISH.getValue());
        Date toDay = new Date();
        int dayNum = DateUtil.daysBetween(order.getStartDate(), toDay);
        order.setDayNum(dayNum);
        order.setTotalAmount(order.getMonthRent() / 30 * dayNum);
        order.setEndDate(toDay);
        orderService.update(order);

        House house = houseService.get(order.getHouseId());
        if (house != null && Objects.equals(house.getStatus(), HouseStatusEnum.HAS_RENT.getValue())) {
            house.setStatus(HouseStatusEnum.NOT_RENT.getValue());
            house.setLastOrderEndTime(new Date());
            houseService.update(house);
        }
        return JsonResult.success("Rent refund successful");
    }


    /**
     * Reject refund
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/admin/order/endReject", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult endReject(@RequestParam("orderId") Long orderId) {
        Order order = orderService.get(orderId);
        if (order == null) {
            return JsonResult.error("Order does not exist");
        }

        Long loginUserId = getLoginUserId();

        if (!Objects.equals(loginUserId, order.getOwnerUserId()) &&
                !loginUserIsAdmin()) {
            return JsonResult.error("No permission");
        }

        order.setStatus(OrderStatusEnum.END_APPLY_REJECT.getValue());
        orderService.update(order);

        return JsonResult.success("Reject Success");
    }


}
