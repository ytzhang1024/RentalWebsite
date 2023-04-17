package com.yutian.zhang.rental.controller.backend;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.constant.Constant;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Password Controller
 * @description Handle requests for changing password
 * @author Yutian Zhang
 * @date 23/12/2021 16:29
 */
@Controller
public class PasswordController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * Reset password page
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/password")
    public String password(Model model) {
        model.addAttribute("tab", "my-password");
        return "admin/my-password";
    }

    /**
     * Password submit
     *
     * @return
     */
    @RequestMapping(value = "/admin/password/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult submitPassword(@RequestParam("oldPassword") String oldPassword,
                                     @RequestParam("newPassword") String newPassword,
                                     @RequestParam("confirmPassword") String confirmPassword,
                                     HttpSession session) {
        if (!Objects.equals(newPassword, confirmPassword)) {
            return JsonResult.error("The password entered twice does not match");
        }

        User user = userService.get(getLoginUserId());
        if (user == null || !Objects.equals(user.getUserPass(), oldPassword)) {
            return JsonResult.error("Old password is incorrect");
        }
        try {
            user.setUserPass(newPassword);
            userService.update(user);
            session.setAttribute(Constant.SESSION_USER_KEY, userService.get(getLoginUserId()));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to save password");
        }
        return JsonResult.success("Save successful");
    }
}
