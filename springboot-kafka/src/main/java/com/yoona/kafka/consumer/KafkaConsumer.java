package com.yoona.kafka.consumer;

import com.yoona.kafka.common.TopicConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2023-03-16 17:33
 */
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {TopicConstants.TEST_TOPIC})
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }

}
