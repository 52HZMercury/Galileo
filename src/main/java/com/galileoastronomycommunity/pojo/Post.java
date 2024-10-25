package com.galileoastronomycommunity.pojo;

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
    private String pid;
    private int uid;
    private String imgPath;
    private String type;
    private String content;
    private String time;
    private String like;
    private String comment;
    private String collect;
}
