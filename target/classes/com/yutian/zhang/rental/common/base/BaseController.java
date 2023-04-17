package com.yutian.zhang.rental.common.base;

import com.yutian.zhang.rental.common.enums.UserRoleEnum;
import com.yutian.zhang.rental.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * BaseController
 * @descrition Provide basic functions
 * @author Yutian Zhang
 * @date 17/12/2021 10:47
 */
@Controller
public abstract class BaseController {


    @Autowired
    private HttpServletRequest request;


    /**
     * Render 404 page
     *
     * @return redirect:/404
     */
    public String renderNotFound() {
        return "forward:/404";
    }


    /**
     * Render 403 page
     *
     * @return redirect:/403
     */
    public String renderNotAllowAccess() {
        return "redirect:/403";
    }

    /**
     * To get the login user
     *
     * @return
     */
    public User getLoginUser() {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    /**
     * get user id
     *
     * @return
     */
    public Long getLoginUserId() {
        User user = getLoginUser();
        if (user == null) {
            return null;
        }
        return user.getId();
    }

    /**
     * Check if the user is administrator
     *
     * @return
     */
    public Boolean loginUserIsAdmin() {
        User loginUser = getLoginUser();
        if (loginUser != null) {
            return UserRoleEnum.ADMIN.getValue().equalsIgnoreCase(loginUser.getRole());
        }

        return false;
    }

    /**
     * Check if the user is tenant
     *
     * @return
     */
    public Boolean loginUserIsCustomer() {
        User loginUser = getLoginUser();
        if (loginUser != null) {
            return UserRoleEnum.CUSTOMER.getValue().equalsIgnoreCase(loginUser.getRole());
        }

        return false;
    }


    /**
     * Check if the user is landlord
     *
     * @return
     */
    public Boolean loginUserIsOwner() {
        User loginUser = getLoginUser();
        if (loginUser != null) {
            return UserRoleEnum.OWNER.getValue().equalsIgnoreCase(loginUser.getRole());
        }
        return false;
    }


}
