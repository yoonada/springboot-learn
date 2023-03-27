package com.yoona.redis.standalone.controller;

import com.yoona.redis.standalone.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-27 11:25
 */
@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/queryByKey")
    public String queryByKey(@RequestParam("key") String key) {
        return testService.queryByKey(key);
    }

    @PostMapping("/setStringKey")
    public String setStringKey(@RequestParam("key") String key,
                               @RequestParam("value") String value) {
        return testService.setStringKey(key, value);
    }


}
