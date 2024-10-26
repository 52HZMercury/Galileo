package com.galileo.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import com.galileo.service.LogService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-20 20:13
 **/
@RestController
public class LogController {

    @Autowired
    private LogService logService;


    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "")
    @Parameters(@Parameter(name = "logid",description = "输入电话号码或者账号绑定的邮箱"))
    public Map<String,String> login(String logid, String password){

        Map<String,String> nameToken = logService.doLogin(logid,password);

        return nameToken;
    }
}
