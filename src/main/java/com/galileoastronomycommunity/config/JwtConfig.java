package com.galileoastronomycommunity.config;

import com.galileoastronomycommunity.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-22 14:03
 **/
@ConfigurationProperties(prefix = "config.jwt")
@Component
@Data
public class JwtConfig {

    private String encryKey;
    private long expire;
    private String header;

    /**
     * 获取toke
     * @return
     */
    public  String getToken(User user){
//        System.out.println(encryKey);
        long currentTime = System.currentTimeMillis();
        //过期时间
        Date expireTime = new Date(currentTime + expire * 1000);
        //也可以直接传入 Map<String, Object> 做简单的修改即可
        Map<String, Object> map = new HashMap<>();
        map.put("UID", user.getUID());
        return Jwts.builder()
                .setId(UUID.randomUUID().toString()) //当前用户
                .setIssuedAt(new Date()) //签发日期
                .setSubject("system") //说明
                .setIssuer("npy") //签发者信息
                .signWith(SignatureAlgorithm.HS512, encryKey) //加密方式
                .addClaims(map)
                .setExpiration(expireTime) //过期时间
                .compact();
    }

    /**
     * 验证是否到时间
     * @param token
     * @return
     */
    public  boolean isExpiration(String token){
        try {
            long currentTime = System.currentTimeMillis();
            return Jwts.parser().setSigningKey(encryKey).parseClaimsJws(token).getBody().getExpiration().after(new Date(currentTime));
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 获取claims 获取 Token 中注册信息
     * @param token
     * @return
     */
    public  Claims getClamis(String token){
        try {
            Claims claims = Jwts.parser().setSigningKey(encryKey).parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }



//    public static void main(String[] args) {
//        String token =
//"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjOTRmMTYyNy00MzMxLTQzZmMtYWY4My1iNmM5ZTA1M2UzNTIiLCJpYXQiOjE1NjcwODQ1MzUsInN1YiI6InN5c3RlbSIsImlzcyI6Im5weSIsInVzZXJJZCI6MTM4OSwidXNlcm5hbWUiOiIxMSIsImV4cCI6MTU2NzE5MjUzNX0.hUssKQEWZwg59tCls7FseXtvkde6XQ44FVSM1R437Rw";
//        System.out.println(JwtUtil.getClamis(token, "salt").get("userId"));
//        System.out.println(JwtUtil.getClamis(token, "salt").get("username"));
//    }
}

