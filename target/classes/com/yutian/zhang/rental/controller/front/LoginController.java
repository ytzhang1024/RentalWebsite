package com.yutian.zhang.rental.controller.front;

import cn.hutool.core.util.RandomUtil;
import com.yutian.zhang.rental.common.constant.Constant;
import com.yutian.zhang.rental.common.enums.HouseRentTypeEnum;
import com.yutian.zhang.rental.common.enums.UserStatusEnum;
import com.yutian.zhang.rental.common.util.MailUtil;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.HouseService;
import com.yutian.zhang.rental.service.UserService;
import com.yutian.zhang.rental.common.dto.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Login controller
 * @description Handle request for login
 * @author Yutian Zhang
 * @date 05/01/2022 15:22
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    /**
     * Login Page
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(Model model) {
        // To show the whole rent house
        List<House> recentWholeHouseList = houseService.findTopList(HouseRentTypeEnum.WHOLE.getValue(), 6);
        model.addAttribute("recentWholeHouseList", recentWholeHouseList);

        // To show the share rent house
        List<House> recentShareHouseList = houseService.findTopList(HouseRentTypeEnum.SHARE.getValue(), 6);
        model.addAttribute("recentShareHouseList", recentShareHouseList);

        model.addAttribute("openLogin", "Y");
        return "front/index";
    }


    /**
     * Login Submit
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/login/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult loginSubmit(@RequestParam("userName") String userName,
                                  @RequestParam("userPass") String userPass,
                                  HttpSession session) {
        // Check if the username exists
        User user = userService.findByUserName(userName);
        if (user == null) {
            return JsonResult.error("User does not exist");
        }

        // Check if the password is correct
        if (!Objects.equals(user.getUserPass(), userPass)) {
            return JsonResult.error("Wrong password");
        }

        // Check if the user has disabled
        if (Objects.equals(user.getStatus(), UserStatusEnum.DISABLE.getValue())) {
            return JsonResult.error("Account has been disabled");
        }

        // Login successful
        session.setAttribute(Constant.SESSION_USER_KEY, user);
        return JsonResult.success("Login successful");
    }

    /**
     * Registration Submit
     *
     * @param userName
     * @param userName
     * @param userPass
     * @param userDisplayName
     * @param email
     * @param phone
     * @param role
     * @return
     */
    @RequestMapping(value = "/register/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult registerSubmit(@RequestParam("userName") String userName,
                                     @RequestParam("userPass") String userPass,
                                     @RequestParam("userDisplayName") String userDisplayName,
                                     @RequestParam("email") String email,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("role") String role,
                                     HttpSession session) {
        // check whether the length of a username is legal
        if (userName.length() < 4 || userName.length() > 20) {
            return JsonResult.error("User name length is not legal");
        }
        // check whether the length of a name is legal
        if (userDisplayName.length() < 2 || userDisplayName.length() > 20) {
            return JsonResult.error("Name length is not legal");
        }
        // check if a email length is legal
        if (email.length() < 5 || email.length() > 50) {
            return JsonResult.error("Email length is not legal");
        }
        // check if a phone length is legal
        if (phone.length() != 10) {
            return JsonResult.error("Mobile phone length is not legal");
        }
        // Check if the username exists
        User user = userService.findByUserName(userName);
        if (user != null) {
            return JsonResult.error("Username occupied");
        }

        //Sign up
        user = new User();
        user.setUserName(userName);
        user.setUserDisplayName(userDisplayName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setUserAvatar("/assets/img/default-avatar.jpg");
        user.setUserPass(userPass);
        user.setRole(role);
        user.setCreateTime(new Date());
        user.setGender("budget not to say");
        user.setUserDesc("Not yet filled！");
        user.setNationality("Not yet filled！");
        try {
            userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Registration failed");
        }
        session.setAttribute(Constant.SESSION_USER_KEY, user);
        return JsonResult.success("Registration success");
    }


    /**
     * Password Reset
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/forget/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult forgetSubmit(@RequestParam("userName") String userName,
                                   @RequestParam("email") String email,
                                   HttpSession session) {
        // Check if the username exists
        User user = userService.findByUserName(userName);
        if (user == null) {
            return JsonResult.error("User does not exist");
        }

        // Username and email do not match
        if (!Objects.equals(email, user.getEmail())) {
            return JsonResult.error("Username and email do not match");
        }

        // Reset
        String randomPass = RandomUtil.randomNumbers(8);
        try {
            MailUtil.sendMail(email, "Reset password", "New Password:" + randomPass);
            user.setUserPass(randomPass);
            userService.update(user);
            return JsonResult.success("Password reset successful, please check your email");
        } catch (MessagingException e) {
            e.printStackTrace();
            return JsonResult.error("Password reset failed, please contact administrator");
        }
    }

    /**
     * Log out
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/";
    }


}
