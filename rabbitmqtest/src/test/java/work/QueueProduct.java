package work;

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
 * @Date: Create in 2020/6/22 16:20
 */
public class QueueProduct {
    @Test
    public void sendMessage() throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("queue",true,false,false,null);
        for(int i = 1; i<= 20; i++){
            channel.basicPublish("","queue", MessageProperties.PERSISTENT_TEXT_PLAIN,("" + i).getBytes());
    }
        channel.close();
        connection.close();
    }
}
