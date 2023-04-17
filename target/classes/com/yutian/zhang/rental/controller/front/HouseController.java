package com.yutian.zhang.rental.controller.front;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.enums.HouseRentTypeEnum;
import com.yutian.zhang.rental.common.util.MailUtil;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.common.vo.HouseSearchVO;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.entity.Order;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.HouseService;
import com.yutian.zhang.rental.service.OrderService;
import com.yutian.zhang.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * House Controller
 *
 * @author Yutian Zhang
 * @date 20/12/2021 20:05
 */
@Controller
public class HouseController extends BaseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    /**
     * Get house list and display in fornt-end
     *
     * @param houseSearchVO
     * @param model
     * @return
     */
    @RequestMapping("/house")
    public String houseList(HouseSearchVO houseSearchVO, Model model) {
        Page page = PageUtil.initMpPage(houseSearchVO.getPage(), houseSearchVO.getSize());

        Page<House> housePage = houseService.getHousePage(houseSearchVO, page);
        model.addAttribute("pageInfo", housePage);

        model.addAttribute("houseSearchVO", houseSearchVO);
        model.addAttribute("pagePrefix", houseSearchVO.getPagePrefix());

        return "front/house-list";
    }


    /**
     * House details
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/house/detail/{id}")
    public String search(@PathVariable("id") Long id, Model model) {


        House house = houseService.get(id);
        if (house == null) {
            return this.renderNotFound();
        }

        List<String> slideList = JSON.parseArray(house.getSlideUrl(), String.class);
        house.setSlideImgList(slideList);

        User owner = userService.get(house.getUserId());
        model.addAttribute("owner", owner);


        List<House> shareHouseList = houseService.findByUserIdAndCertificateNoAndRentType(house.getUserId(), house.getCertificateNo(), HouseRentTypeEnum.SHARE.getValue());
        for (House houseTemp : shareHouseList) {
            Order currentOrder = orderService.getCurrentEffectiveOrder(houseTemp.getId());
            if (currentOrder != null) {
                currentOrder.setCustomerUser(userService.get(currentOrder.getCustomerUserId()));
            }
            houseTemp.setCurrentOrder(currentOrder);
        }
        house.setShareHouseList(shareHouseList);
        model.addAttribute("house", house);
        return "front/house-detail";
    }

    /**
     * House Map
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/house/map")
    public String map(@RequestParam("id") Long id, Model model) {
        House house = houseService.get(id);
        if (house == null) {
            return this.renderNotFound();
        }
        String longitudeLatitude = house.getLongitudeLatitude();
        String[] arr = longitudeLatitude.split(",");
        if (arr.length == 2) {
            model.addAttribute("longitude", arr[0]);
            model.addAttribute("latitude", arr[1]);
        }
        model.addAttribute("address", house.getAddress());
        return "front/house-googlemap";
    }


    /**
     * Contact landlord
     *
     * @param session
     * @return
     */
    @RequestMapping("/house/contact")
    @ResponseBody
    public JsonResult contact(@RequestParam("houseId") Long houseId,
                              @RequestParam("name") String name,
                              @RequestParam("phone") String phone,
                              @RequestParam("email") String email,
                              @RequestParam("content") String content, HttpSession session) {
        User user = getLoginUser();
        if (user == null) {
            return JsonResult.error("Please log in first");
        }
        House house = houseService.get(houseId);
        if (house == null) {
            return JsonResult.error("House does not exist");
        }
        User owner = userService.get(house.getUserId());
        if (owner == null) {
            return JsonResult.error("Landlord does not exist");
        }
        String ownerEmail = owner.getEmail();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Name: ").append(name).append("<br/>");
            sb.append("Phone Number: ").append(phone).append("<br/>");
            sb.append("Email: ").append(email).append("<br/>");
            sb.append("Content: ").append(content).append("<br/>");
            sb.append("Link: ").append("http://20.224.100.114:8080/house/detail/").append(houseId).append("<br/>");
            sb.append("Please contact each other for further communication. ");
            MailUtil.sendMail(ownerEmail, name + " enquiries about renting a room", sb.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
            return JsonResult.error("Email delivery failed");
        }
        return JsonResult.success("Mail sent successfully");
    }

}
