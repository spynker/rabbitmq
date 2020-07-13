package com.yangbo;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 10:16
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange =@Exchange(value = "topic_logs",type = "topic"),
                    key = {"hello.*"}
            )
    })
    public void topicConsumer1(String message){
        System.out.println("topicConsumer1 : " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange =@Exchange(value = "topic_logs",type = "topic"),
                    key = {"error"}
            )
    })
    public void topicConsumer2(String message){
        System.out.println("topicConsumer2 : " + message);
    }
}
