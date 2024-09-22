package com.galileoastronomycommunity.service;

import com.galileoastronomycommunity.pojo.User;
import com.galileoastronomycommunity.mapper.UserMapper;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.galileoastronomycommunity.config.JwtConfig;

import java.util.HashMap;
import java.util.Map;

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
    @Resource
    private JwtConfig jwtConfig ;

    public Map<String,String> doLogin(String logid ,String password) {
        //使用BCryptPasswordEncoder对数据库中的加密密码进行匹配
        BCryptPasswordEncoder Encoder = new BCryptPasswordEncoder();

        User loginUser = userMapper.loadUserByUserId(logid);
        Map<String,String> nameToken = new HashMap<>() ;
        if(loginUser != null){

            //该matches方法需要把密码写在前面,加密后的密码写在后面
            if(Encoder.matches(password,loginUser.getPassword())){
                //生成token
                String token = jwtConfig.getToken(loginUser) ;
                if (!StringUtils.isEmpty(token)) {
                    nameToken.put(loginUser.getUname(),token) ;
                }else{
                    nameToken.put(loginUser.getUname(),"token生成失败") ;
                }
//                //test
//                System.out.println(jwtConfig.getClamis(nameToken.get(loginUser.getUname())).get("UID"));
                return nameToken;
            }
            nameToken.put("token","登录失败，输入密码不正确") ;
            return nameToken;
        }
        nameToken.put("token","登录失败，用户不存在") ;


        return nameToken;
    }


}
