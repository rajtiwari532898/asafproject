package com.tcs.common;


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

public class JMSListener {
	
	public static void main(String[] args) {
		
		try {/*
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			
			env.put(Context.PROVIDER_URL, "jnp://01hw606216:1099");
			
			env.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			
			String putText="";

			// Create the initial context

			Context ctx = new InitialContext(env);

			// Lookup the JMS connection factory from the JBoss 5.1 object store

			ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");

			// Lookup a queue from the JBoss 5.1 object store

			while(true)
			{
			
			Queue queue = (javax.jms.Queue) ctx.lookup("/queue/Proxy_1");
			

			// Create a connection to the JBoss 5.1 Message Service

			Connection connection = connectionFactory.createConnection();

			// Create a session within the connection

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Create a message producer to put messages on the queue

			MessageProducer messageProducer = session.createProducer(queue);

			// Create and send a message to the queue

			TextMessage textMessage = session.createTextMessage();

			textMessage.setText("Hello World");

			System.out.println("Sending Message: " + textMessage.getText());

			messageProducer.send(textMessage);
			
            //added by syed
			
			Queue queueSubscribe = (javax.jms.Queue) ctx.lookup("/queue/Proxy_2");
			
			// Create a message consumer

			MessageConsumer messageConsumer = session.createConsumer(queue);

			// Start the Connection created

			connection.start();

			// Receive a message from the queue.

			Message msg = messageConsumer.receive();

			// Retrieve the contents of the message.

			if (msg instanceof TextMessage) {

				TextMessage txtMsg = (TextMessage) msg;

				System.out.println("Read Message: " + txtMsg.getText());
				
				putText = txtMsg.getText()+"___Modified";
			}
			
			TextMessage textMessage = session.createTextMessage();
			textMessage.setText(putText);
			
			Queue queueSubscribe = (javax.jms.Queue) ctx.lookup("/queue/Proxy_2");
			
			MessageProducer messageProducer = session.createProducer(queueSubscribe);
			messageProducer.send(textMessage);

			// Close the session and connection resources.

			session.close();

			connection.close();
			}

		*/
		
			sendJmsRequest("Good");
			String msg=receiveJmsResponse();
			System.out.println("msg recive-->"+msg);
		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}
	public  static void sendJmsRequest(String inputData) throws NamingException, JMSException
	{
		
		
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
	
		textMessage.setText(inputData);
		
		Queue queueSubscribe = (javax.jms.Queue) ctx.lookup("/queue/Proxy_1");
		
		MessageProducer messageProducer = session.createProducer(queueSubscribe);
		messageProducer.send(textMessage);

		// Close the session and connection resources.

		session.close();

		connection.close();
		
	}
	
	public  static String receiveJmsResponse() throws NamingException, JMSException
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

		Queue queue = (javax.jms.Queue) ctx.lookup("/queue/Proxy_2");
		MessageConsumer messageConsumer = session.createConsumer(queue);

		// Start the Connection created

		connection.start();

		// Receive a message from the queue.

		Message msg = messageConsumer.receive();

		// Retrieve the contents of the message.
		TextMessage txtMsg =null;
		
		if (msg instanceof TextMessage) 
		{
			 txtMsg = (TextMessage) msg;
			
		}
		

		// Close the session and connection resources.

		session.close();

		connection.close();
		return txtMsg.getText();
	}
		
		

}
