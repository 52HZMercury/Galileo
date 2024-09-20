package org.example.galileoastronomycommunity.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-09-20 20:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int UID;
    private String password;
}
