package com.demo.springbootmybatis.kafka.producer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author lilinlin
 */
@Component
public class MsgProducer {

    private static final Logger log = LoggerFactory.getLogger(MsgProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topicName, String jsonData) {
        log.info("向kafka推送数据:[{}]", jsonData);
        ListenableFuture<SendResult<String, String>> future = null;
        try {
            future = kafkaTemplate.send(topicName, jsonData);
        } catch (Exception e) {
            log.error("发送数据出错！！！{}{}", topicName, jsonData);
            log.error("发送数据出错=====>", e);
        }

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("数据发送完毕，回掉成功。");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("数据发送完毕，回掉失败。", ex);
            }

//            @Override
//            public boolean isInterestedInSuccess() {
//                log.info("数据发送完毕");返回成功、失败会分别调用onSuccess，onFailure所以不需要实现
//                return false;
//            }

        });

        //消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
                log.info("数据发送完毕，回掉成功。");
            }

            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
                log.info("数据发送完毕，回掉失败。");
            }

            @Override
            public boolean isInterestedInSuccess() {
                log.info("数据发送完毕");
                return false;
            }
        });
    }
}