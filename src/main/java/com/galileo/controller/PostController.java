package com.galileo.controller;

import com.galileo.service.PostService;
import com.galileo.service.UserService;
import com.galileo.util.FileUtil;
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
public class PostController {


    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @PostMapping(value = "/PostingImage",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "发送帖子图片",description = "上传图片")
    public String fileUpload(@RequestPart("file") MultipartFile file,String token) throws Exception {
        //先上传帖子图片
        FileUtil fileUtil = new FileUtil();
        String fileName = fileUtil.doFileUpload(file);

        return postService.doAddPost(token,fileName);
    }

    @PostMapping(value = "/PostingContent")
    @Operation(summary = "发送帖子文本",description = "上传文本")
    public String ContentUpload(int pid,String content) {
        try {
            postService.doAddPostContent(pid,content);
            return "发布成功";
        } catch (Exception e) {
            throw new RuntimeException("发布失败");
        }

    }


    @PostMapping(value = "/headImgload")
    @Operation(summary = "上传头像图片接口",description = "登录")
    public boolean headImgload(MultipartFile file) {

        FileUtil fileUtil = new FileUtil();
        //Service.addimg
        fileUtil.doHeadImgload(file);
        return true;

    }

}
