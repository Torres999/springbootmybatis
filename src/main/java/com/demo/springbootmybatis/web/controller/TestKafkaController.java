package com.demo.springbootmybatis.web.controller;

import com.demo.springbootmybatis.kafka.producer.MsgProducer;
import com.demo.springbootmybatis.model.common.ResponseResult;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lilinlin
 */
@RestController
@Slf4j
public class TestKafkaController {
    @Autowired
    MsgProducer msgProducer;

    @RequestMapping(value = "/sendKafkaMsg", method = RequestMethod.GET)
    public ResponseEntity<ResponseResult> editAppointmentMerchantUseStatus(
            @ApiParam(value = "msg", required = true) @RequestParam String msg,
            @ApiParam(value = "[testTopic,topic1,topic2]") @RequestParam(required = false) String topic) {
        log.info("receive a request send kafka msg.msg:{},topic:{}", msg, topic);

        msgProducer.sendMessage(topic, msg);
//        msgProducer.sendMessage("topic-1", "这是一段用于测试的消息内容。");
//        msgProducer.sendMessage("topic-2", "{\"msg\":\"这是一段用于测试json的消息内容。\"}");
//        msgProducer.sendMessage("test-topic", "这是一段用于测试的消息内容。");

        return new ResponseEntity("OK", HttpStatus.OK);
    }
}
