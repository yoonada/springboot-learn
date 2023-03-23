package com.yoona.kafka.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.yoona.kafka.common.TopicConstants;
import com.yoona.kafka.domain.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-16 16:47
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/kafka/{msg}")
    public void sendMessage(@PathVariable("msg") String msg) {
        MessageDTO dto = MessageDTO.builder()
                .uuid(IdUtil.simpleUUID())
                .message(msg)
                .build();
        kafkaTemplate.send(TopicConstants.TEST_TOPIC, JSON.toJSONString(dto));
    }


}
