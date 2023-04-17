package com.yutian.zhang.rental.controller.backend;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.constant.Constant;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.enums.HouseStatusEnum;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * House Controller
 *
 * @author Yutian Zhang
 * @date 22/12/2021 13:45
 */
@Controller("backHouseController")
public class HouseController extends BaseController {

    @Autowired
    private HouseService houseService;

    /**
     * House Management
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/house")
    public String allHouse(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                           @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                           Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        House condition = new House();

        if (!loginUserIsAdmin()) {
            condition.setUserId(getLoginUserId());
        }
        Page<House> housePage = houseService.findAll(page, condition);
        model.addAttribute("pageInfo", housePage);

        model.addAttribute("tab", "house-list");
        model.addAttribute("pagePrefix", "/admin/house?");

        model.addAttribute("isAdmin", loginUserIsAdmin());
        return "admin/house-list";
    }


    /**
     * Publish and Edit House Info
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/house/publish")
    public String publish(@RequestParam(value = "id", required = false) Long id, Model model) {
        House house;
        if (id != null) {
            house = houseService.get(id);
            if (house == null) {
                return this.renderNotFound();
            }
            if (!loginUserIsAdmin() && !Objects.equals(house.getUserId(), getLoginUserId())) {
                return this.renderNotAllowAccess();
            }
        } else {
            house = new House();
        }
        model.addAttribute("house", house);
        model.addAttribute("tab", "house-publish");
        return "admin/house-publish";
    }


    /**
     * Submit house info
     *
     * @return
     */
    @RequestMapping(value = "/admin/house/publish/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult publishSubmit(House house, @RequestParam("key") String imgKey, HttpSession session) {
        try {
            if (house.getId() == null) {
                house.setCreateTime(new Date());
                house.setUserId(getLoginUserId());
            }

            List<String> imgUrlList = (List<String>) session.getAttribute(Constant.SESSION_IMG_PREFIX + imgKey);
            if (imgUrlList != null && imgUrlList.size() > 0) {
                house.setThumbnailUrl(imgUrlList.get(0));
                house.setSlideUrl(JSON.toJSONString(imgUrlList));
            }

            if (house.getLongitudeLatitude() != null && !house.getLongitudeLatitude().contains(",")) {
                return JsonResult.error("Please enter the correct latitude and longitude coordinates");
            }

            house.setStatus(HouseStatusEnum.NOT_CHECK.getValue());
            houseService.insertOrUpdate(house);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Publish failed, please fill in the full information");
        }
        return JsonResult.success("Publish successful", house.getId());
    }


    /**
     * Delete house
     *
     * @return
     */
    @RequestMapping(value = "/admin/house/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteHouse(@RequestParam("id") Long id) {
        try {
            House house = houseService.get(id);
            if (house == null) {
                return JsonResult.error("House does not exist");
            }
            if (!loginUserIsAdmin() && !Objects.equals(house.getUserId(), getLoginUserId())) {
                return JsonResult.error("No permission to delete");
            }
            if (Objects.equals(house.getStatus(), HouseStatusEnum.HAS_RENT.getValue())) {
                return JsonResult.error("Delete failed");
            }
            houseService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Fail to delete house");
        }
        return JsonResult.success("Delete successful");
    }

    /**
     * Put on market
     *
     * @return
     */
    @RequestMapping(value = "/admin/house/up", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult upHouse(@RequestParam("id") Long id) {
        try {
            House house = houseService.get(id);
            if (house == null) {
                return JsonResult.error("House does not exist");
            }
            if (!loginUserIsAdmin() && !Objects.equals(house.getUserId(), getLoginUserId())) {
                return JsonResult.error("No permission to delete");
            }
            if (Objects.equals(house.getStatus(), HouseStatusEnum.HAS_RENT.getValue())) {
                return JsonResult.error("The house is being rented and cannot be taken off the market");
            }
            house.setStatus(HouseStatusEnum.NOT_RENT.getValue());
            houseService.update(house);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failure to put the house on the market");
        }
        return JsonResult.success("Success to put the house on the market");
    }

    /**
     * Remove the house from the market
     *
     * @return
     */
    @RequestMapping(value = "/admin/house/down", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult downHouse(@RequestParam("id") Long id) {
        try {
            House house = houseService.get(id);
            if (house == null) {
                return JsonResult.error("House does not exist");
            }
            if (!loginUserIsAdmin() && !Objects.equals(house.getUserId(), getLoginUserId())) {
                return JsonResult.error("No permission to delete");
            }
            if (Objects.equals(house.getStatus(), HouseStatusEnum.HAS_RENT.getValue())) {
                return JsonResult.error("The house is being rented and cannot be taken off the market");
            }
            house.setStatus(HouseStatusEnum.HAS_DOWN.getValue());
            houseService.update(house);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Fail to remove");
        }
        return JsonResult.success("Remove success");
    }


    /**
     * Review approved
     *
     * @return
     */
    @RequestMapping(value = "/admin/house/checkPass", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkPass(@RequestParam("id") Long id) {
        try {
            House house = houseService.get(id);
            if (house == null) {
                return JsonResult.error("House does not exist");
            }
            if (!loginUserIsAdmin()) {
                return JsonResult.error("No permission to delete");
            }
            if (!Objects.equals(house.getStatus(), HouseStatusEnum.NOT_CHECK.getValue())) {
                return JsonResult.error("Only houses pending review can be reviewed");
            }
            house.setStatus(HouseStatusEnum.NOT_RENT.getValue());
            houseService.update(house);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to approve");
        }
        return JsonResult.success("Review successful");
    }


    /**
     * Review failed
     *
     * @return
     */
    @RequestMapping(value = "/admin/house/checkReject", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkReject(@RequestParam("id") Long id) {
        try {
            House house = houseService.get(id);
            if (house == null) {
                return JsonResult.error("House does not exist");
            }
            if (!loginUserIsAdmin()) {
                return JsonResult.error("No permission to delete");
            }
            if (!Objects.equals(house.getStatus(), HouseStatusEnum.NOT_CHECK.getValue())) {
                return JsonResult.error("Only houses pending review can be reviewed");
            }
            house.setStatus(HouseStatusEnum.CHECK_REJECT.getValue());
            houseService.update(house);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Reject fail");
        }
        return JsonResult.success("Reject success");
    }


}
