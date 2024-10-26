package com.galileo.service;

import com.galileo.mapper.UserMapper;
import com.galileo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-21 15:06
 **/
@Service
public class RegisterService {

    @Autowired
    private UserMapper userMapper;

    public boolean doRegister(User newUser) {
        //对密码进行加密存储
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodePassword);

        // 判断是否重复
        if (userMapper.selectExistPnumber(newUser.getPnumber())) {
            return false;
        }

        // 执行注册
        userMapper.addUser(newUser);
        return true;
    }
}
