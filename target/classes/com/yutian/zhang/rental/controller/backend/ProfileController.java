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
import java.util.List;

/**
 * Profile controller
 *
 * @author Yutian Zhang
 * @date 22/12/2021 16:35
 */
@Controller
public class ProfileController extends BaseController {

    @Autowired
    private UserService userService;


    /**
     * Personal info page
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/profile")
    public String profile(Model model) {
        User user = userService.get(getLoginUserId());
        model.addAttribute("user", user);
        model.addAttribute("tab", "my-profile");
        return "admin/my-profile";
    }


    /**
     * personal info sumbit
     *
     * @return
     */
    @RequestMapping(value = "/admin/profile/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult submitProfile(@RequestParam("key") String imgKey, User user, HttpSession session) {
        List<String> avatar = (List<String>)session.getAttribute(Constant.SESSION_IMG_PREFIX + imgKey);
        if (avatar != null && avatar.size() > 0) {
            user.setUserAvatar(avatar.get(0));
        }
        user.setId(getLoginUserId());
        try {
            userService.update(user);
            session.setAttribute(Constant.SESSION_USER_KEY, userService.get(getLoginUserId()));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to save user info");
        }
        return JsonResult.success("Save successful");
    }

}
