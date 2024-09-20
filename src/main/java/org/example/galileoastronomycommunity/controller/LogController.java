package org.example.galileoastronomycommunity.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.galileoastronomycommunity.service.LogService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-20 20:13
 **/
@RestController
@Tag(name = "用户管理")
public class LogController {

    @Autowired
    private LogService logService;


    @GetMapping("/login")
    @Operation(summary = "用户登录", description = "")
    @Parameter(description = "参数描述")
    public boolean login(int id, String password, HttpSession session){

        boolean islogin = logService.doLogin(id,password);

        return islogin;
    }
}
