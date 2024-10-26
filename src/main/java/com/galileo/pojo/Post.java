package com.galileo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-21 17:18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int pid;        /** 帖子id **/
    private int uid;        /** 用户id **/
    private String imgPath; /** 图片路径 **/
    private String type;    /** 星星类型 **/
    private String content; /** 文本 **/
    private String time;    /** 发布时间 **/
    private String like;    /** 点赞数 **/
    private String comment; /** 评论 **/
    private String collect; /** 收藏数 **/
    private int viewCount;  /** 浏览量 **/
}
