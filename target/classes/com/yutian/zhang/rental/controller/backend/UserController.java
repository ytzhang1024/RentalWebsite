package com.yutian.zhang.rental.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.enums.UserStatusEnum;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User Controller
 *
 * @author Yutian Zhang
 * @date 05/1/2022 14:25
 */
@Controller("backUserController")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * User List
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/user")
    public String allUser(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                          @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                          Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        User condition = new User();
        Page<User> userPage = userService.findAll(page, condition);
        model.addAttribute("pageInfo", userPage);

        model.addAttribute("tab", "user-list");
        model.addAttribute("pagePrefix", "/admin/user?");
        return "admin/user-list";
    }


    /**
     * Disable User
     *
     * @return
     */
    @RequestMapping(value = "/admin/user/disable", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult disableUser(@RequestParam("id") Long id) {
        try {
            User user = userService.get(id);
            if (user != null) {
                user.setStatus(UserStatusEnum.DISABLE.getValue());
                userService.update(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to disable user");
        }
        return JsonResult.success("Disable user successful");
    }


    /**
     * Enable User
     *
     * @return
     */
    @RequestMapping(value = "/admin/user/enable", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult enableUser(@RequestParam("id") Long id) {
        try {
            User user = userService.get(id);
            if (user != null) {
                user.setStatus(UserStatusEnum.ENABLE.getValue());
                userService.update(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to enable user");
        }
        return JsonResult.success("Enable User Success");
    }

    /**
     * Delete user
     *
     * @return
     */
    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteUser(@RequestParam("id") Long id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to delete user");
        }
        return JsonResult.success("Delete successful");
    }


}
