package com.demo;

import com.demo.springbootmybatis.SpringbootMybatisApplication;
import com.demo.springbootmybatis.kafka.producer.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lilinlin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class KafkaTest {

    @Autowired
    private MsgProducer msgProducer;

    @Test
    public void test() throws Exception {

//        msgProducer.sendMessage("topic1", "这是一段用于测试的消息内容。");
        msgProducer.sendMessage("topic2", "{\"msg\":\"这是一段用于测试json的消息内容。\"}");
//        msgProducer.sendMessage("testTopic", "这是一段用于测试的消息内容。");
    }
}
