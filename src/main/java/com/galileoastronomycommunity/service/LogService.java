package com.galileoastronomycommunity.service;

import com.galileoastronomycommunity.pojo.User;
import com.galileoastronomycommunity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-20 20:14
 **/
@Service
public class LogService {

    @Autowired
    private UserMapper userMapper;
    public String doLogin(String logid ,String password) {
        //使用BCryptPasswordEncoder对数据库中的加密密码进行匹配
        BCryptPasswordEncoder Encoder = new BCryptPasswordEncoder();

        User loginUser = userMapper.loadUserByUserId(logid);

        if(loginUser != null){
//            String passHash = "$2a$10$L0rQ7lXAFPso8Y2cbRDxtOaMj1EP.PCVvUm4y1l5LVn2pT.jy/FIS";
//            String pass = "741";
//            final boolean matches = encoder.matches(pass, passHash);
//            System.out.println(matches);

            //该matches方法需要把密码写在前面,加密后的密码写在后面
            if(Encoder.matches(password,loginUser.getPassword())){
                return loginUser.getUname();
            }
            return "登录失败，输入密码不正确";
        }
        return "登录失败，用户不存在";

    }
}
