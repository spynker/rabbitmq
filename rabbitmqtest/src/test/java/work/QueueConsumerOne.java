package work;

import com.rabbitmq.client.*;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/22 16:23
 */
public class QueueConsumerOne {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //消费者一次只取出一个消息
//        channel.basicQos(1);
        channel.queueDeclare("queue",true,false,false,null);
        channel.basicConsume("queue",false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                /*try {
                    Thread.sleep(1000);

                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println("consumer1 : " + new String(body));
            }
        });
    }
}
