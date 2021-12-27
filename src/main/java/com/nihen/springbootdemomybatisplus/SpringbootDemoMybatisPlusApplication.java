package com.nihen.springbootdemomybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
@SpringBootApplication
@MapperScan("com.nihen.springbootdemomybatisplus.mapper")
public class SpringbootDemoMybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoMybatisPlusApplication.class, args);
	}

}
