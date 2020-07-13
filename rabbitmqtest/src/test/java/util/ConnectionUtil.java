package util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/22 10:23
 */
public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
      /*  ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
        Connection connection = connectionFactory.newConnection();
        return connection;*/
        Properties prop = new Properties();
        prop.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("prop.properties"));
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(prop.getProperty("host"));
        connectionFactory.setPort(Integer.parseInt(prop.getProperty("port")));
        connectionFactory.setVirtualHost(prop.getProperty("virtualHost"));
        connectionFactory.setUsername(prop.getProperty("userName"));
        connectionFactory.setPassword(prop.getProperty("password"));
        return connectionFactory.newConnection();
    }
}
