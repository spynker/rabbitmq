package fanout;

import com.rabbitmq.client.*;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/22 18:03
 */
public class FanoutConsumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //通道绑定交换机
        channel.exchangeDeclare("logs","fanout");
        //临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定交换机和队列
        channel.queueBind(queueName, "logs", "");

        //消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2：" + new String(body));
            }
        });
    }
}
