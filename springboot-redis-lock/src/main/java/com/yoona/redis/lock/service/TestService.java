package com.yoona.redis.lock.service;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-21 10:09
 */
public interface TestService {

    /**
     * 初始化库存
     *
     * @param productId
     * @param num
     */
    void initStock(Integer productId, Integer num);

    /**
     * 减库存
     * @param productId
     * @return
     * @throws InterruptedException
     */

    String deductStock(Integer productId) throws InterruptedException;

}
