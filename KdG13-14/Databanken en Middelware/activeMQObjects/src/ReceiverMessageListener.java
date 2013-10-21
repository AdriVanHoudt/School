import org.apache.activemq.ActiveMQConnectionFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import pojo.Beurskoers;


import javax.jms.*;
import java.io.StringReader;


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

                StringReader sr = null;
                try {
                    sr = new StringReader(((TextMessage)message).getText());

                    Beurskoers bs = null;

                    bs = (Beurskoers) Unmarshaller.unmarshal(Beurskoers.class , sr);

                    System.out.println(bs.getAandeel());
                    System.out.println(bs.getPrijs());
                } catch (MarshalException | ValidationException | JMSException e) {
                    e.printStackTrace();
                }



            }
        } ;
        consumer.setMessageListener(listener);

        Thread.sleep(1000000000);


    }
}
