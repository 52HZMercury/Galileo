package com.galileoastronomycommunity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-21 17:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int CID;
    private int PID;
    private int UID;
    private String content;
}
