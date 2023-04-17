package com.yutian.zhang.rental.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.Feedback;
import com.yutian.zhang.rental.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * Feedback Controller
 *
 * @author Yutian Zhang
 * @date 28/1/2022 13:06
 */
@Controller("backFeedbackController")
public class FeedbackController extends BaseController {

    @Autowired
    private FeedbackService feedbackService;


    /**
     * Feedback list
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/feedback")
    public String allFeedback(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                              @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                              Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        Feedback condition = new Feedback();
        // Administrator can see all feedback while general users can access their own feedback
        if (!loginUserIsAdmin()) {
            condition.setUserId(getLoginUserId());
        }
        Page<Feedback> feedbackPage = feedbackService.findAll(page, condition);
        model.addAttribute("pageInfo", feedbackPage);

        model.addAttribute("tab", "feedback-list");
        model.addAttribute("pagePrefix", "/admin/feedback?");
        model.addAttribute("isAdmin", loginUserIsAdmin());
        return "admin/feedback-list";
    }


    /**
     * Reply feedback
     *
     * @return
     */
    @RequestMapping(value = "/admin/feedback/reply/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult replySubmit(Feedback feedback) {
        try {
            feedbackService.update(feedback);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Save failure");
        }
        return JsonResult.success("Save successful");
    }

    /**
     * Delete Feedback
     *
     * @return
     */
    @RequestMapping(value = "/admin/feedback/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteFeedback(@RequestParam("id") Long id) {
        try {
            Feedback feedback = feedbackService.get(id);
            if (feedback == null) {
                return JsonResult.error("Feedback not exist");
            }
            if (!loginUserIsAdmin() && !Objects.equals(feedback.getUserId(), getLoginUserId())) {
                return JsonResult.error("No permission to delete");
            }
            feedbackService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to delete feedback");
        }
        return JsonResult.success("Delete feedback successfully");
    }

}
