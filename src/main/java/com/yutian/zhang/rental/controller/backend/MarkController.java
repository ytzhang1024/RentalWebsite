package com.yutian.zhang.rental.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.Mark;
import com.yutian.zhang.rental.service.HouseService;
import com.yutian.zhang.rental.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * Mark Controller
 * Handling request for marking house
 * @author Yutian Zhang
 * @date 15/1/2022 17:31
 */
@Controller("backMarkController")
public class MarkController extends BaseController {

    @Autowired
    private MarkService markService;

    @Autowired
    private HouseService houseService;


    /**
     * Get all marks
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/mark")
    public String allFeedback(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                              @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                              Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        Mark condition = new Mark();
        condition.setUserId(getLoginUserId());

        Page<Mark> markPage = markService.findAll(page, condition);
        for (Mark temp : markPage.getRecords()) {
            temp.setHouse(houseService.get(temp.getHouseId()));
        }
        model.addAttribute("pageInfo", markPage);

        model.addAttribute("tab", "mark-list");
        model.addAttribute("pagePrefix", "/admin/mark?");
        return "admin/mark-list";
    }


    /**
     * Cancel mark
     *
     * @return
     */
    @RequestMapping(value = "/admin/mark/cancel", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult cancelMark(@RequestParam("id") Long id) {
        try {
            Mark mark = markService.get(id);
            if (mark != null && Objects.equals(mark.getUserId(), getLoginUserId())) {
                markService.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to delete favorites");
        }
        return JsonResult.success("Delete successful");
    }


}
