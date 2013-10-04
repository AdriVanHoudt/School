import pojo.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;

import javax.jms.*;
import java.io.StringWriter;


/**
 * User: Adri
 * Date: 4/10/13
 * Time: 9:17
 */
public class Sender {
    public static void main(String[] args) throws JMSException, MarshalException, ValidationException {
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

        Beurskoers bk = new Beurskoers("OOG", 500);
        StringWriter sw = new StringWriter();

        Marshaller.marshal(bk, sw);

        String message = sw.toString();
        TextMessage txtmsg  = session.createTextMessage(message);

        producer.send(txtmsg);


    }


}
