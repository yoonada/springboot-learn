package com.yoona.redis.lock.service.impl;

import com.yoona.redis.lock.constant.Constants;
import com.yoona.redis.lock.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-21 10:10
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final StringRedisTemplate stringRedisTemplate;

    private final RedissonClient redissonClient;

    /**
     * 初始化库存
     *
     * @param productId
     * @param num
     */
    @Override
    public void initStock(Integer productId, Integer num) {
        String redisKey = String.join(":", Constants.REDIS_PRODUCT_PREFIX, String.valueOf(productId));
        stringRedisTemplate.opsForValue().set(redisKey, String.valueOf(num));
    }

/*        @Override
    public String deductStock(Integer productId) {
        String redisKey = String.join(":", Constants.REDIS_PRODUCT_PREFIX, String.valueOf(productId));
        String lockKey = "product_" + productId;
        try {
            Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "distributed_lock", 10, TimeUnit.SECONDS);
            if (Boolean.FALSE.equals(lock)) {
                return "当前请求人数太多，请稍后再试";
            }
            int stock = Integer.parseInt(Objects.requireNonNull(stringRedisTemplate.opsForValue().get(redisKey)));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set(redisKey, String.valueOf(realStock));
                log.info("扣减成功，剩余库存：{}", realStock);
            } else {
                log.error("扣减失败，库存不足");
            }
        } finally {
            // 释放锁
            stringRedisTemplate.delete(lockKey);
        }
        return "end";
    }*/

    /**
     * 采用Redisson实现分布式锁
     * @param productId
     * @return
     * @throws InterruptedException
     */
    @Override
    public String deductStock(Integer productId) throws InterruptedException {
        String redisKey = String.join(":", Constants.REDIS_PRODUCT_PREFIX, String.valueOf(productId));
        String lockKey = "product_" + productId;
        RLock rLock = redissonClient.getLock(lockKey);
        try {
            boolean resultLock = rLock.tryLock(30, 10, TimeUnit.SECONDS);
            if (resultLock){
                int stock = Integer.parseInt(Objects.requireNonNull(stringRedisTemplate.opsForValue().get(redisKey)));
                if (stock > 0) {
                    int realStock = stock - 1;
                    stringRedisTemplate.opsForValue().set(redisKey, String.valueOf(realStock));
                    log.info("扣减成功，剩余库存：{}", realStock);
                } else {
                    log.error("扣减失败，库存不足");
                }
            }
        }
         finally {
            rLock.unlock();
        }
        return "end";
    }

}
