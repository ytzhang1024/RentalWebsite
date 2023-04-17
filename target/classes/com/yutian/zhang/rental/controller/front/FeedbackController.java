package com.yutian.zhang.rental.controller.front;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.enums.FeedbackStatusEnum;
import com.yutian.zhang.rental.entity.Feedback;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.FeedbackService;
import com.yutian.zhang.rental.common.dto.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Feedback Controller
 *
 * @author Yutian Zhang
 * @date 27/1/2022 20:06
 */
@Controller("frontFeedbackController")
public class FeedbackController extends BaseController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/feedback")
    public String index() {
        return "front/feedback";
    }

    /**
     * Feedback submit
     *
     * @param title
     * @param content
     * @param contactName
     * @param contactEmail
     * @return
     */
    @RequestMapping("/feedback/submit")
    @ResponseBody
    public JsonResult submit(@RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("contactName") String contactName,
                             @RequestParam("contactEmail") String contactEmail) {
        User loginUser = getLoginUser();
        if (loginUser == null) {
            return JsonResult.error("Please log in first");
        }

        Feedback feedback = new Feedback();
        feedback.setCreateTime(new Date());
        feedback.setStatus(FeedbackStatusEnum.NOT_HANDLE.getValue());
        feedback.setUserId(loginUser.getId());
        feedback.setTitle(title);
        feedback.setContent(content);
        feedback.setContactName(contactName);
        feedback.setContactEmail(contactEmail);
        feedbackService.insert(feedback);
        return JsonResult.success("Feedback Success, Please wait for the administrator to process");
    }
}
