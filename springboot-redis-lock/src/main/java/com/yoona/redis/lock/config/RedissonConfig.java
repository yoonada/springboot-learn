package com.yoona.redis.lock.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-23 15:40
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private Integer dateBase;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        String address = String.join("", "redis://", host, ":", port);
        config.useSingleServer().setAddress(address).setPassword(password).setDatabase(dateBase);
        return Redisson.create(config);
    }

}
