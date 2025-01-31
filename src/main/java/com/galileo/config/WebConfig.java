package com.galileo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: Galileo Astronomy Community
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-18 20:15
 **/

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //配置映射路径，使得前端可以访问文件的地址
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:/MyProgram/Galileo/src/main/resources/static/images/posts/");
    }
    // windows D:/MyProgram/Galileo/src/main/resources/static/images/posts/
    // linux   /www/wwwroot/Galileo/postsImages/



}