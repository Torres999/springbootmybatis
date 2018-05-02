package com.demo.springbootmybatis.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lilinlin
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "szqy.test1.kafka.server:9092");
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");//doesn't work when AUTO_COMMIT is false.
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group-lin");
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "none");// thrown exception to consumer when offset is not exist.
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return propsMap;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        /**
         * auto.commit为false时生效，默认是AckMode.BATCH(参考ContainerProperties.java和KafkaMessageListenerContainer.java)
         * RECORD：每处理一条commit一次
         * BATCH：每次client从server poll到所有的消息后批量提交一次，所以具体commit频率取决于每次poll的调用频率
         * TIME：每次间隔ackTime的时间去commit
         * COUNT：累积达到ackCount次的ack去commit
         * COUNT_TIME：ackTime或ackCount哪个条件先满足，就commit
         * MANUAL：listener负责ack，但是背后也是批量上去
         * MANUAL_IMMEDIATE：listner负责ack，每调用一次，就立即commit
         */
//        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.COUNT);
//        factory.getContainerProperties().setAckCount(5);
        // 或者：
//        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.TIME);
//        factory.getContainerProperties().setAckTime(1000);
        return factory;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
}