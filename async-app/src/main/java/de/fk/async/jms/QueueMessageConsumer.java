package de.codedoor.async.workshop.jms;

import jakarta.ejb.MessageDriven;
import jakarta.ejb.MessageDrivenContext;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.Topic;

import jakarta.annotation.Resource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

@MessageDriven(name = "QueueMessageConsumer")
public class QueueMessageConsumer implements MessageListener {

    @Resource
    private MessageDrivenContext mdcContext;

    @Resource
    private ConnectionFactory sibConnectionFactory;

    @Resource(name = "jms/asyncAppConnectionFactory")
    private ConnectionFactory asyncAppConnectionFactory;

    @Resource(name = "jms/asyncAppTopic")
    private Topic topic;

    @Override
    public void onMessage(Message message) {
        System.out.println("QueueMessageConsumer: " + message);
//        new JmsTemplate(asyncAppConnectionFactory).send(topic, (MessageCreator) session -> message);

//        mdcContext.setRollbackOnly();
//		Connection con = null;
//		try {
//			con = topicConnectionFactory.createConnection();
//			Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			MessageProducer producer = session.createProducer(topic);
//			if (message instanceof TextMessage) {
//				producer.send(session.createTextMessage(((TextMessage) message).getText()));
//			} else {
//				producer.send(message);
//			}
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (con != null) {
//				try {
//					con.close();
//				} catch (JMSException e) {
//					e.printStackTrace();
//				}
//			}
//		}
    }

}
