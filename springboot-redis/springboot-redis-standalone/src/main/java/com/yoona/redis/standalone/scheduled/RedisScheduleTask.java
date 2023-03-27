package com.yoona.redis.standalone.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-27 10:03
 */
@Slf4j
@Configuration
public class RedisScheduleTask {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Scheduled(fixedRate = 60000)
    private void configureTasks() {
        stringRedisTemplate.execute(RedisConnectionCommands::ping);
    }

}
