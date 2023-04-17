package com.yutian.zhang.rental.common.interceptor;

import com.yutian.zhang.rental.common.constant.Constant;
import com.yutian.zhang.rental.common.enums.UserRoleEnum;
import com.yutian.zhang.rental.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Interceptor for administrator request
 *
 * @author example
 */
@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {
        User user = (User) request.getSession().getAttribute(Constant.SESSION_USER_KEY);
        // user not log in
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        // not administrator
        if (!UserRoleEnum.ADMIN.getValue().equalsIgnoreCase(user.getRole())) {
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}

