package com.galileoastronomycommunity.controller;

import com.galileoastronomycommunity.service.UserService;
import com.galileoastronomycommunity.util.FileUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-29 16:38
 **/
@RestController
public class FileController {


    @Autowired
    private UserService userService;


    @PostMapping(value = "/fileload")
    @Operation(summary = "上传图片接口",description = "上传图片接口,注意！！！一定要先发送了动态 (就是先调用了/add接口)的其他信息以后，最后才上传图片")
    public boolean fileUpload(MultipartFile file) {

        FileUtil fileUtil = new FileUtil();
        //Service.addimg
        fileUtil.doFileUpload(file);
        return true;
    }



    @PostMapping(value = "/headImgload")
    @Operation(summary = "上传头像图片接口",description = "前提也是你已经登录")
    public boolean headImgload(MultipartFile file) {

        FileUtil fileUtil = new FileUtil();
        //Service.addimg
        fileUtil.doHeadImgload(file);
        return true;

    }

}
