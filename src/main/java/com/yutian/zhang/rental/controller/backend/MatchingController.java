package com.yutian.zhang.rental.controller.backend;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.entity.Matching;
import com.yutian.zhang.rental.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Matching Controller
 * @descpition Handle matching attributes
 * @author Yutian Zhang
 * @date 2/2/2022 10:42
 */

@Controller
public class MatchingController extends BaseController {

    @Autowired
    private MatchingService matchingService;

    /**
     * Matching Page
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/matching")
    public String matching(Model model) {
        Long userID = getLoginUserId();

        if(!matchingService.checkUserExist(userID)){
            matchingService.createUserMatching(userID);
        }
        Matching matching = matchingService.findMatchingAttributes(userID);
        model.addAttribute("matching", matching);
        model.addAttribute("tab", "my-matching");
        return "admin/my-matching";
    }

    /**
     * Matching Page
     *
     * @param matching
     * @param session
     * @return
     */
    @RequestMapping(value = "/admin/matching/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult matchingSave(Matching matching, HttpSession session){
        Long id = getLoginUserId();
        matching.setId(id);
        try {
            matchingService.update(matching);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to save matching info");
        }
        return JsonResult.success("Save successful");
    }

}
