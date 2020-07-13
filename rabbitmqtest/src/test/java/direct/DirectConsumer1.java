package direct;

import com.rabbitmq.client.*;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/22 23:17
 */
public class DirectConsumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //通道和交换机绑定
        channel.exchangeDeclare("logs_direct", "direct");
        //随机生成队列
        String queue = channel.queueDeclare().getQueue();
        //绑定队列和交换机
        channel.queueBind(queue, "logs_direct", "info");

        channel.basicConsume(queue, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer1 : " + new String(body));
            }
        });
    }
}
