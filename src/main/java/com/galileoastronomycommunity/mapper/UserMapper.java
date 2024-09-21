package com.galileoastronomycommunity.mapper;
import com.galileoastronomycommunity.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-20 20:22
 **/
@Mapper
@Repository
public interface UserMapper {
    User loadUserByUserId(String logid);
    void addUser(User user);
    boolean selectExistPnumber(String pnumber);
}
