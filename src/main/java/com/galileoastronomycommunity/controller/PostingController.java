package com.galileoastronomycommunity.controller;

import com.galileoastronomycommunity.service.UserService;
import com.galileoastronomycommunity.util.FileUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
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
public class PostingController {


    @Autowired
    private UserService userService;


    @PostMapping(value = "/Postingload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "发送帖子接口",description = "上传图片和文案")
    public String fileUpload(@RequestPart("file") MultipartFile file,String token) throws Exception {
        //先上传帖子图片
        FileUtil fileUtil = new FileUtil();
        //Service.addimg
        String response = fileUtil.doFileUpload(file,token);


        //配上文案

        return response;
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
