package org.example.galileoastronomycommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.galileoastronomycommunity.mapper")
public class GalileoAstronomyCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalileoAstronomyCommunityApplication.class, args);
	}

}
