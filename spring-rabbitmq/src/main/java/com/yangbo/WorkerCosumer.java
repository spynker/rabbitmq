package com.yangbo;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 9:35
 */
@Component
public class WorkerCosumer {

    @RabbitListener(queuesToDeclare = @Queue(value = "worker"))
    public void consume1(String message){
        System.out.println("consumer1 : " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "worker"))
    public void consume2(String message){
        System.out.println("consumer2 : " + message);
    }
}
