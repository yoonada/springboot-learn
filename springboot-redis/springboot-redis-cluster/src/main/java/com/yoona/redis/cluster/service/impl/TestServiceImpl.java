package com.yoona.redis.cluster.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yoona.redis.cluster.service.TestService;
import com.yoona.redis.cluster.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-27 11:28
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final RedisUtil redisUtil;

    /**
     * 根据key获取value
     *
     * @param key
     * @return
     */
    @Override
    public String queryByKey(String key) {
        log.info(IdUtil.simpleUUID());
        return (String) redisUtil.get(key);
    }

    /**
     * 设置String类型的key和value
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public String setStringKey(String key, String value) {
        boolean set = redisUtil.set(key, value);
        if (set) {
            return "success";
        }
        return "fail";
    }
}
