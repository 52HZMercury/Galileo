package com.galileoastronomycommunity.service;

import com.galileoastronomycommunity.config.JwtConfig;
import com.galileoastronomycommunity.mapper.PostingMapper;
import com.galileoastronomycommunity.pojo.Post;
import com.galileoastronomycommunity.util.ModelCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-21 19:20
 **/
@Service
public class PostingService {

    @Autowired
    private PostingMapper postingMapper;

    /**
     * @Description: 识别图片并发布帖子
     * @Param:
     * @return:
     */
    public String doAddPosting(String token,String filePathName) throws Exception {
        String filetype = "";
        //token 没过期
        JwtConfig jwtConfig = new JwtConfig();
        if(jwtConfig.isExpiration(token)){
            //调用模型识别
            Map<String, Float> result =  new ModelCaller().recognize(filePathName);
            filetype = result.get(result.keySet().toArray()[0]).toString();
            System.out.println(filetype);

            //图片路径存储到数据库
            int UID = (int) jwtConfig.getClamis(token).get("UID");
            System.out.println(UID);

            Post newPost = new Post();
            newPost.setUid(UID);
            newPost.setImgPath(filePathName);
            newPost.setType(filetype);

            //得到刚刚添加的posting的id
            postingMapper.addPosting(newPost);
        }else {
            filetype = "error : token已经过期，请重新获取";
        }
        return filetype;
    }
}
