import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

/**
 * User: Adri
 * Date: 4/10/13
 * Time: 9:17
 */
public class Sender {
    public static void main(String[] args) throws JMSException {
        // Create a ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Create a Connection to ActiceMQ
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Create a Session that allows you to work with activeMQ
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // Create the destination queue (or retrieve it, if it already exists)
        Destination destination = session.createQueue("TEST.SENDRECEIVE");

        // Create a MessageProducer for the Destination
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        Boolean b = Boolean.TRUE;
        Scanner scanner = new Scanner(System.in);

        while (b){
            String input = scanner.nextLine();

            if (input.equals("exit")){ b = Boolean.FALSE;}

            TextMessage message = session.createTextMessage(input);
            producer.send(message);


        }
        System.exit(0);
    }


}
