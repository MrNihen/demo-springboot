package com.nihen.springbootdemomybatisplus.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 雪花算法
 */
@Slf4j
@Configuration
public class SnowflakeConfig {

    @Bean
    public Snowflake snowflake() {

        // 对于单体应用来说，这种方式没有问题，如果是分布式的话，workId 或者 datacenterId 是不能一致的，不然的话是可能重复的
        return IdUtil.getSnowflake(0, 1);
    }
}
