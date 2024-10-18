package com.galileoastronomycommunity.util;


import com.galileoastronomycommunity.config.JwtConfig;
import jakarta.annotation.Resource;
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


    public String doFileUpload(MultipartFile file,String token) throws Exception {

        String filetype = "";
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
        }finally {
            //token 没过期
            JwtConfig jwtConfig = new JwtConfig();
            if(jwtConfig.isExpiration(token)){
                System.out.println("test");
                //调用模型识别
                Map<String, Float> result =  new ModelCaller().recognize(filePath+fileName);
                filetype = result.get(result.keySet().toArray()[0]).toString();
                System.out.println(filetype);

                //图片路径存储到数据库
                int UID = (int) jwtConfig.getClamis(token).get("UID");
                System.out.println(UID);
                //addImg("img/postingImages/" +fileName, dynamicMapper.addNewDId());
            }else {
                filetype = "error";
                fileName = "token已经过期，请重新获取";
            }
        }
        return filetype+":"+fileName;

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
