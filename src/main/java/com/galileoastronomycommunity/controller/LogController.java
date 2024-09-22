package com.galileoastronomycommunity.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.galileoastronomycommunity.service.LogService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-20 20:13
 **/
@RestController
@Tag(name = "用户登录")
public class LogController {

    @Autowired
    private LogService logService;


    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "")
    @Parameters(@Parameter(name = "logid",description = "输入电话号码或者账号绑定的邮箱"))
    public Map<String,String> login(String logid, String password, HttpSession session){

        Map<String,String> nameToken = logService.doLogin(logid,password);

        return nameToken;
    }
}
