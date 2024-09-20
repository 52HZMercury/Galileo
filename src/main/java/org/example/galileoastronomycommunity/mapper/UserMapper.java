package org.example.galileoastronomycommunity.mapper;
//import com.baomidou.mybatisplus.annotation.*;
import org.example.galileoastronomycommunity.pojo.User;
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
    User loadUserByUserId(int id);
}
