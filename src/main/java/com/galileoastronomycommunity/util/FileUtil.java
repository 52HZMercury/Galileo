package com.galileoastronomycommunity.util;


import com.galileoastronomycommunity.config.JwtConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-29 16:48
 **/
public class FileUtil {


    public String doFileUpload(MultipartFile file) throws Exception {

        String fileName = file.getOriginalFilename();//获取文件的原始的名字
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//文件后缀
        String filePath = "D:/MyProgram/Galileo Astronomy Community/src/main/resources/static/images/posting/";
        // linux /www/wwwroot/GalileoAstronomyCommunity/postingImages/
        // develop D:/MyProgram/Galileo Astronomy Community/src/main/resources/static/images/posting/
        fileName = UUID.randomUUID() + suffixName;//通过uuid生成唯一标识符
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;

    }

    public String doHeadImgload(MultipartFile file) {

        String fileName = file.getOriginalFilename();//获取文件的原始的名字
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//文件后缀
        String filePath = "/www/wwwroot/LostandFound/backgroundSystem/lostandfoundimg/head/";
        // linux /www/wwwroot/LostandFound/backgroundSystem/lostandfoundimg/dynamic/
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //token userid
        }
        return fileName;

    }

}
