package com.yoona.join;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dell
 */
@MapperScan("com.yoona.join.mapper")
@SpringBootApplication
public class MybatisPlusJoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusJoinApplication.class, args);
    }

}
