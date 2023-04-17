package com.yutian.zhang.rental.controller.backend;

import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.constant.Constant;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * FileController
 * @descrition Dealing with file upload
 * @author Yutian Zhang
 * @date 28/1/2022 13:06
 */
@Controller
public class FileController extends BaseController {


    /**
     * file upload
     *
     * @param file
     * @param key
     * @return JsonResult
     */
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadFile(@RequestParam("file") MultipartFile file,
                                 @RequestParam("key") String key,
                                 HttpSession session) {
        Map<String, String> resultMap = null;
        try {
            resultMap = FileUtil.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Upload failed");
        }
        String filePath = resultMap.get("filePath");


        // Store the image URL in the session
        String sessionKey = Constant.SESSION_IMG_PREFIX + key;
        List<String> imgList = (List<String>) session.getAttribute(sessionKey);
        if (imgList == null) {
            imgList = new ArrayList<>();
        }
        imgList.add(filePath);
        session.setAttribute(sessionKey, imgList);
        return JsonResult.success("Upload successful");
    }
}
