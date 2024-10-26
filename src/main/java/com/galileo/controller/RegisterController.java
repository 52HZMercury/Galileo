package com.galileo.controller;

import com.galileo.pojo.User;
import com.galileo.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-21 15:11
 **/

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    @Operation(summary = "用户注册", description = "")
    @Parameters({@Parameter(name = "pnumber",description = "注册用 电话号码"),@Parameter(name = "password",description = "注册用 密码"),@Parameter(name = "password",description = "注册用 用户名")})
    public boolean register(String pnumber,String password,String uname){
        User newUser = new User(pnumber,password,uname);
        return registerService.doRegister(newUser);
    }
}
