package com.yutian.zhang.rental.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Error Controller
 *
 * @author Yutian Zhang
 * @date  13/02/2022 15:25
 */

@Controller
public class ErrorController {


    /**
     * Render error pages
     *
     * @param request request
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/error")
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode.equals("400")) {
            return "redirect:/400";
        } else if(statusCode.equals("403")) {
            return "redirect:/403";
        } else if(statusCode.equals("404")) {
            return "redirect:/404";
        } else {
            return "redirect:/500";
        }
    }

    /**
     * 400
     *
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/400")
    public String fourZeroZero() {
        return "common/error/400";
    }


    /**
     * 403
     *
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/403")
    public String fourZeroThree() {
        return "common/error/403";
    }


    /**
     * 404
     *
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/404")
    public String fourZeroFour() {
        return "common/error/404";
    }


    /**
     * 500
     *
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/500")
    public String fiveZeroZero() {
        return "common/error/500";
    }

}
