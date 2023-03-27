package com.yoona.redis.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yoonada
 */
@EnableScheduling
@SpringBootApplication
public class SpringbootRedisStandaloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisStandaloneApplication.class, args);
    }

}
