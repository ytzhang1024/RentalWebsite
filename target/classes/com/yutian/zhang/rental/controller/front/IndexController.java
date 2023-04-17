package com.yutian.zhang.rental.controller.front;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.enums.HouseRentTypeEnum;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Home page controller
 *
 * @author Yutian Zhang
 * @date 19/12/2021 20:25
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private HouseService houseService;


    /**
     * Display latest houses
     *
     * @param model
     * @return homepage
     */
    @RequestMapping("/")
    public String index(Model model) {
        // display whole rent houses
        List<House> recentWholeHouseList = houseService.findTopList(HouseRentTypeEnum.WHOLE.getValue(), 6);
        model.addAttribute("recentWholeHouseList", recentWholeHouseList);

        // display shared rent houses
        List<House> recentShareHouseList = houseService.findTopList(HouseRentTypeEnum.SHARE.getValue(), 6);
        model.addAttribute("recentShareHouseList", recentShareHouseList);

        return "front/index";
    }


}
