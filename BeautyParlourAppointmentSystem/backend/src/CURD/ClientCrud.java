package CURD;
import java.security.Provider.Service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import parlour.Client;

public class ClientCrud {
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;
	
	static {
		 sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	public static Transaction getTransaction() {
		return session.beginTransaction();   
	}
	public static void closeSession() {
		session.close();
		System.out.println("Session Closed");
	}
	
	public static void closeSessionFactory() {
		 if (session != null) {
		        session.close();
		        System.out.println("Session Closed");
		    }
		    if (sessionFactory != null) {
		        sessionFactory.close();
		        System.out.println("Session Factory Closed");
		    }
	}
	public static boolean CreateClient(Client c) {
		try {
			session = getSession(); 
			transaction = getTransaction();
			session.save(c);
			transaction.commit();
	        System.out.println("Client created successfully!");
	        return true;
	        
	    }  
	        catch (Exception e) {
	        System.out.println("Error creating client: " + e.getMessage());
	    } 
		return false;
	}
	public static Client getClient(int ClientId) {
		Client c=(Client)session.get(Client.class,ClientId);
		return c;
	}

	public static boolean UpdateClientRecord(Client c) {
		try {
			transaction = session.beginTransaction();
			session.update(c);
			transaction.commit();
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	public static boolean deleteClient(Client c) {
		try {
			
			transaction = session.beginTransaction();
			session.delete(c); 
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}