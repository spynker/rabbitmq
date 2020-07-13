package com.yangbo;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 9:46
 */
@Component
public class FanoutConsumer {


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs",type = "fanout")
            )
    })
    public void fanoutConsumer1(String message){
        System.out.println("consumer1 : " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs",type = "fanout")
            )
    })
    public void fanoutConsumer2(String message){
        System.out.println("consumer2 : " + message);
    }
}
