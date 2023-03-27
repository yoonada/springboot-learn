package com.yoona.redis.standalone.service;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-27 11:28
 */
public interface TestService {

    /**
     * 根据key获取value
     *
     * @param key
     * @return
     */
    String queryByKey(String key);

    /**
     * 设置String类型的key和value
     *
     * @param key
     * @param value
     * @return
     */
    String setStringKey(String key, String value);
}
