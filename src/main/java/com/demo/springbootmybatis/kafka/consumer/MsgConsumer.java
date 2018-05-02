package com.demo.springbootmybatis.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author lilinlin
 */
@Component
public class MsgConsumer {

    @KafkaListener(topics = {"topic1"})
//    public void processMessage(String content,Acknowledgment ack) { //前提要配置AckMode，KafkaConsumerConfig.java
//        System.out.println("消息被消费，消息内容是：" + content);
//        ack.acknowledge();
//    }
    public void processMessage(String content) {
        System.out.println("消息被消费，消息内容是：" + content);
    }

    @KafkaListener(id = "id1", topicPattern = "topic2")
    public void listen(@Payload String foo,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.OFFSET) String offset) {
        System.out.println("foo = [" + foo + "], partition = [" + partition + "], topic = [" + topic + "], offset = [" + offset + "]");
    }

    @KafkaListener(topics = {"testTopic"}) //多个method的情况下随机选择一个
    public void listen2(ConsumerRecord<?, ?> record) {
        System.out.println("record: " + record);//record: ConsumerRecord(topic = testTopic, partition = 0, offset = 4, key = null, value = 1234)
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            System.out.println("kafkaMessage: " + kafkaMessage);//kafkaMessage: Optional[1234]
            Object message = kafkaMessage.get();
            System.out.println("listen2: " + message);//listen2: 1234
        }
    }
}