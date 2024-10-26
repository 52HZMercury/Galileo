package com.galileo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@MapperScan("com.galileo.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GalileoAstronomyCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalileoAstronomyCommunityApplication.class, args);
	}

}
