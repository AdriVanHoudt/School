import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: Adri
 * Date: 4/10/13
 * Time: 9:38
 */
public class Receiver {
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

        // Create a MessageConsumer
        MessageConsumer consumer = session.createConsumer(destination);
        //consumer.setMessageListener(DeliveryMode.NON_PERSISTENT);

        while (true){
            // this call blocks until a new message arrives
            Message message = consumer.receive();
            TextMessage textMessage = (TextMessage) message;

            System.out.println(textMessage.getText());

            if (textMessage.getText().equals("exit")){
                consumer.close();
                session.close();
                connection.close();

                System.exit(0);
            }


        }


    }
}
