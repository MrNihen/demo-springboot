package com.nihen.springbootdemomybatisplus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootDemoMybatisPlusApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testRandom(){
		Random random = new Random();
		int num = random.nextInt(999);
		System.out.println(num);
		System.out.println("======================================");
		int num2 = num + 1;
		System.out.println(num2);
	}

}
