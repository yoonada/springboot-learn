package com.yoona.redis.lock.controller;

import com.yoona.redis.lock.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-20 16:55
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    /**
     * 初始化库存
     *
     * @param productId
     * @param num
     */
    @GetMapping("/initStock")
    public void initStock(@RequestParam("productId") Integer productId,
                          @RequestParam("num") Integer num) {
        testService.initStock(productId, num);
    }

    @GetMapping("/deductStock/{productId}")
    public String deductStock(@PathVariable("productId") Integer productId) throws InterruptedException {
        return testService.deductStock(productId);
    }


}

