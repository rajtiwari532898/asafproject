package com.tcs.common;




import java.math.BigDecimal;
import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.gov.bgc.bean.Applicant;
import com.gov.bgc.bean.BGCResponse;
import com.tcs.dvt.bean.UserRegistrationBean;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class UserRegistraionJMS {
	
	public static void main(String[] args) {
		
		try {
			
			UserRegistrationBean userRegistrationBean=new UserRegistrationBean();
			
			userRegistrationBean.setFirstName("hjhsajkd");
			userRegistrationBean.setAnnualExpence(new BigDecimal("2233"));
			userRegistrationBean.setAnnualIncome(new BigDecimal("100000"));
			userRegistrationBean.setSsn("123456789");
//			Applicant appl = new Applicant();
//			appl.setFirstName("Anuj");
//			appl.setAnnualExpense( 300000);
//			appl.setAnnualIncome (1000000);
//			appl.getApplicantAditionalDtls().setSsn("123456789");
//			XStream xstream = new XStream(new DomDriver());
//			String xml = xstream.toXML(appl);
//			System.out.println(">>>>"+xml);
			
			sendJmsRequest(userRegistrationBean);
			BGCResponse bGCResponse=receiveJmsResponse();
			System.out.println(bGCResponse.getBgcIndex());
//			XStream xstream1 = new XStream(new DomDriver());
//			BGCResponse bGCResponse= (BGCResponse)xstream1.fromXML(msg);
			//System.out.println("msg recive-->"+msg);
		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}
	public  static void sendJmsRequest(UserRegistrationBean userRegistrationBean) throws NamingException, JMSException
	{
		Applicant appl = new Applicant();
		appl.setFirstName(userRegistrationBean.getFullName());
		appl.setAnnualExpense( userRegistrationBean.getAnnualExpence().intValue());
		appl.setAnnualIncome (userRegistrationBean.getAnnualIncome().intValue());
		appl.getApplicantAditionalDtls().setSsn(userRegistrationBean.getSsn());
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(appl);
		System.out.println(">>>>"+xml);
		
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		
		env.put(Context.PROVIDER_URL, "jnp://01hw606216:1099");
		
		env.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
		
		String putText="";

		// Create the initial context

		Context ctx = new InitialContext(env);
		
		
		
		ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");

		// Lookup a queue from the JBoss 5.1 object store

		
		//Queue queue = (javax.jms.Queue) ctx.lookup("/queue/Proxy_1");
		

		// Create a connection to the JBoss 5.1 Message Service

		Connection connection = connectionFactory.createConnection();

		// Create a session within the connection

		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		
		TextMessage textMessage = session.createTextMessage();
	
		textMessage.setText(xml);
		
		Queue queueSubscribe = (javax.jms.Queue) ctx.lookup("/queue/Proxy_Q_Request");
		
		MessageProducer messageProducer = session.createProducer(queueSubscribe);
		messageProducer.send(textMessage);

		// Close the session and connection resources.

		session.close();

		connection.close();
		
	}
	
	public  static BGCResponse receiveJmsResponse() throws NamingException, JMSException
	{
		
		
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		
		env.put(Context.PROVIDER_URL, "jnp://01hw606216:1099");
		
		env.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
		
		String putText="";

		// Create the initial context

		Context ctx = new InitialContext(env);
		
		
		
		ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		
		
		Connection connection = connectionFactory.createConnection();

		// Create a session within the connection
		
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		Queue queue = (javax.jms.Queue) ctx.lookup("/queue/Proxy_Q_Response");
		MessageConsumer messageConsumer = session.createConsumer(queue);

		// Start the Connection created

		connection.start();

		// Receive a message from the queue.

		Message msg = messageConsumer.receive();

		// Retrieve the contents of the message.
		TextMessage txtMsg =null;
		
		
		BGCResponse bGCResponse=null;
		if (msg instanceof TextMessage) 
		{
			 txtMsg = (TextMessage) msg;
			
				XStream xstream1 = new XStream(new DomDriver());
				 bGCResponse= (BGCResponse)xstream1.fromXML(txtMsg.getText());
				System.out.println("msg recive-->"+msg);	
		}
		

		// Close the session and connection resources.

		session.close();

		connection.close();
		return bGCResponse;
	}
		
		

}
