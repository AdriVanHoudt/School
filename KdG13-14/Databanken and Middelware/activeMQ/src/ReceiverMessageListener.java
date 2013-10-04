import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: Adri
 * Date: 4/10/13
 * Time: 9:38
 */
public class ReceiverMessageListener {
    public static void main(String[] args) throws JMSException, InterruptedException {
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
        MessageListener listener = new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage txtmsg = (TextMessage) message;
                try {
                    System.out.println(txtmsg.getText());


                    if (txtmsg.getText().equals("exit")){
                        System.exit(0);
                    }

                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        } ;
        consumer.setMessageListener(listener);

        Thread.sleep(1000000000);


    }
}
