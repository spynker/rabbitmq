package com.yangbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 1:08
 */
@SpringBootTest(classes = SpringRabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class SpringRabbitmqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //simple
    @Test
    public void sendMessage(){
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    //worker
    @Test
    public void workProduct(){
        for(int i =1; i<=20;i++){
            rabbitTemplate.convertAndSend("worker", "hello worker" + i);
        }
    }

    //fanout
    @Test
    public void fanout(){
        for(int i =1; i<=20;i++){
            rabbitTemplate.convertAndSend("logs","", "hello fanout" + i);
        }
    }

    //direct
    @Test
    public void direct(){
        for(int i =1; i<=20;i++){
            rabbitTemplate.convertAndSend("direct_logs","info", "hello direct" + i);
        }
    }

    //topic
    @Test
    public void topic(){
        for(int i =1; i<=20;i++){
            rabbitTemplate.convertAndSend("topic_logs","hello.world", "hello topic" + i);
        }
    }
}
