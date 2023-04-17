package com.yutian.zhang.rental.controller.front;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.entity.Mark;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.MarkService;
import com.yutian.zhang.rental.common.dto.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Marks controller
 *
 * @author Yutian Zhang
 * @date 28/1/2022 21:35
 */
@RestController("markController")
public class MarkController extends BaseController {

    @Autowired
    private MarkService markService;

    /**
     * Mark submit
     *
     * @param houseId
     * @return
     */
    @RequestMapping(value = "/mark/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult submit(@RequestParam("houseId") Long houseId) {
        User loginUser = getLoginUser();
        if (loginUser == null) {
            return JsonResult.error("Please Login First");
        }

        List<Mark> markList = markService.findByUserIdAndHouseId(loginUser.getId(), houseId);
        if (markList != null && markList.size() > 0) {
            return JsonResult.error("Already marked");
        }

        Mark mark = new Mark();
        mark.setCreateTime(new Date());
        mark.setUserId(loginUser.getId());
        mark.setHouseId(houseId);
        markService.insert(mark);
        return JsonResult.success("Mark successful");
    }
}
