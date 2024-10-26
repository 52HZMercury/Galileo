package com.galileo.service;

import com.galileo.config.JwtConfig;
import com.galileo.mapper.PostMapper;
import com.galileo.pojo.Post;
import com.galileo.util.ModelCaller;
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
public class PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private JwtConfig jwtConfig;
    /**
     * @Description: 识别图片并发布帖子
     * @Param:
     * @return:
     */
    public String doAddPost(String token,String fileName) throws Exception {
        String postsimgPath = "/www/wwwroot/Galileo/postsImages/";
        String filetype = "test";
        //token 没过期
        if(jwtConfig.isExpiration(token)){
            //调用模型识别 部署到服务器上再开启
//            Map<String, Float> result =  new ModelCaller().recognize(postsimgPath + fileName);
//            filetype = result.keySet().toArray()[0];
//            System.out.println(filetype);

            //图片路径存储到数据库
            int UID = (int) jwtConfig.getClamis(token).get("UID");

            Post newPost = new Post();
            newPost.setUid(UID);
            newPost.setImgPath(fileName);
            newPost.setType(filetype);

            //得到刚刚添加的posting的id
            postMapper.addPost(newPost);
            System.out.println("posting的id:" + newPost.getPid());

            return newPost.getPid()+" : "+filetype;
        }else {
            return  "error : token已经过期，请重新获取";
        }

    }

    /**
     * @Description: 发布帖子文字
     * @Param:
     * @return:
     */
    public void doAddPostContent(int pid,String content){
        Post newPostContent = new Post();
        newPostContent.setPid(pid);
        newPostContent.setContent(content);
        postMapper.addPostContent(newPostContent);
    }
}
