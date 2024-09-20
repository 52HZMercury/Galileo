package org.example.galileoastronomycommunity.service;

import org.example.galileoastronomycommunity.pojo.User;
import org.example.galileoastronomycommunity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public boolean doLogin(int id ,String password) {

        User loginUser = userMapper.loadUserByUserId(id);

        if(loginUser != null){
            if(Objects.equals(loginUser.getPassword(), password)){
                return true;
            }
            return false;
        }

        return false;


    }
}
