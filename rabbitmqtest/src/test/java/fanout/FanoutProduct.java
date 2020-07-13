package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/22 17:58
 */
public class FanoutProduct {
    @Test
    public void sendMessage() throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //将通道声明指定交换机  //参数1：交换机名称  参数2：交换机类型  fanout:广播类型
        channel.exchangeDeclare("logs", "fanout");

        //发送消息
        channel.basicPublish("logs", "", null, "fanout type message".getBytes());

        //释放资源
        channel.close();
        connection.close();
    }
}
