package com.yangbo;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 0:40
 */
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
@Component
public class Consumer {

    @RabbitHandler
    public void consumer(String message){
        System.out.println(message);
    }

}
