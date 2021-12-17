package com.nihen.springbootdemomybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.nihen.springbootdemomybatisplus.mapper")
public class SpringbootDemoMybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoMybatisPlusApplication.class, args);
	}

}
