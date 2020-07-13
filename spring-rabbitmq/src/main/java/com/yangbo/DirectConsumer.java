package com.yangbo;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 10:05
 */
@Component
public class DirectConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange =@Exchange(value = "direct_logs",type = "direct"),
                    key = {"info"}
            )
    })
    public void directConsumer1(String message){
        System.out.println("directConsumer1 : " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange =@Exchange(value = "direct_logs",type = "direct"),
                    key = {"error"}
            )
    })
    public void directConsumer2(String message){
        System.out.println("directConsumer2 : " + message);
    }
}
