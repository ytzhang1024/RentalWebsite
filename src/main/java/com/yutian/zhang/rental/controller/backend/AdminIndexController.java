package com.yutian.zhang.rental.controller.backend;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage Controller
 *
 * @author Yutian Zhang
 * @date 16/12/2022 10:05
 */
@Controller
public class AdminIndexController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * Administrator Dashboard
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin")
    public String index(Model model) {
        return "admin/index";
    }

}
