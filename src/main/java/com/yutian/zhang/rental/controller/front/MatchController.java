package com.yutian.zhang.rental.controller.front;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.util.MailUtil;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.MatchingService;
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
 * Matching Controller
 *
 * @author Yutian Zhang
 * @date 2/2/2022 13:49
 */

@Controller
public class MatchController extends BaseController {

    @Autowired
    private MatchingService matchingService;

    @Autowired
    private UserService userService;

    /**
     * Matching Page
     * @description Handle the request for displaying matching people
     * @param model
     * @return
     */
    @RequestMapping("/matching")
    public String matchingList(Model model) {
        User loginUser = getLoginUser();
        //check if login
        if (loginUser == null) {
            return "common/loginreminder";
        }

        //get user id
        Long userID = getLoginUserId();
        if (!matchingService.checkUserExist(userID)) {
            return "front/matching-noattributes";
        }

        //check roles
        if (loginUserIsCustomer()) {
            List<User> matchingList = matchingService.matchingList(userID);
            model.addAttribute("matchingList", matchingList);
            return "front/matching-list";
        } else {
            return "redirect:/400";
        }


    }

    @RequestMapping("/matching/contact/{username}")
    public String matchingContact(@PathVariable("username") String username, Model model) {
        User user = userService.findByUserName(username);
        model.addAttribute("potentialRoommate", user);
        return "front/contact";
    }


    @RequestMapping("/roommate/contact")
    @ResponseBody
    public JsonResult contact(@RequestParam("potentialRoommateEmail") String potentialRoommateEmail,
                              @RequestParam("name") String name,
                              @RequestParam("phone") String phone,
                              @RequestParam("email") String email,
                              @RequestParam("content") String content, HttpSession session) {

        User user = getLoginUser();
        if (user == null) {
            return JsonResult.error("Please log in first");
        }

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Name: ").append(name).append("<br/>");
            sb.append("Phone Number: ").append(phone).append("<br/>");
            sb.append("Email: ").append(email).append("<br/>");
            sb.append("Content: ").append(content).append("<br/>");
            sb.append("Please contact each other for further communication. ");
            MailUtil.sendMail(potentialRoommateEmail, name + " want to be your roommate", sb.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
            return JsonResult.error("Email delivery failed");
        }
        return JsonResult.success("Mail sent successfully");
    }


}

