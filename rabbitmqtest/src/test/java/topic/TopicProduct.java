package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/22 23:54
 */
public class TopicProduct {

    @Test
    public void sendMessage() throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics", "topic");
        for(int i =1 ; i <= 20; i++){
            channel.basicPublish("topics", "hello", null , ("topics message--" + i).getBytes());
        }
        channel.close();
        connection.close();
    }
}
