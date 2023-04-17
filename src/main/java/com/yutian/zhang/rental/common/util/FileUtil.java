package com.yutian.zhang.rental.common.util;

import cn.hutool.core.text.StrBuilder;
import com.yutian.zhang.rental.common.constant.Constant;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * File Upload
 *
 * @author KIN_DIN
 * @date 20/1/2019 15:45
 */
public class FileUtil {

    /**
     * File upload
     *
     * @param file
     * @return
     */
    public static Map<String, String> upload(MultipartFile file) throws Exception {
        final Map<String, String> resultMap = new HashMap<>(6);
        try {
            final File mediaPath = new File(Constant.UPLOADS_PATH);
            if (!mediaPath.exists()) {
                if (!mediaPath.mkdirs()) {
                    throw new Exception("File upload failed to create a folder");
                }
            }
            // original file name
            String originFileName = file.getOriginalFilename();
            // file suffix
            final String fileSuffix = originFileName.substring(file.getOriginalFilename().lastIndexOf('.') + 1);
            // File new name
            String nameWithOutSuffix = UUID.randomUUID().toString().replaceAll("-", "");

            //suffix
            String newFileName = nameWithOutSuffix + "." + fileSuffix;

            // check file exist
            File descFile = new File(mediaPath.getAbsoluteFile(), newFileName);
            file.transferTo(descFile);

            // file original path
            final StrBuilder fullPath = new StrBuilder(mediaPath.getAbsolutePath());
            fullPath.append("/");
            fullPath.append(newFileName);

            //file mapping
            final StrBuilder filePath = new StrBuilder("/uploads/");
            filePath.append(nameWithOutSuffix + "." + fileSuffix);


            resultMap.put("fileName", originFileName);
            resultMap.put("filePath", filePath.toString());
            resultMap.put("fileSuffix", fileSuffix);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("File upload failed");
        }
        return resultMap;
    }

}
