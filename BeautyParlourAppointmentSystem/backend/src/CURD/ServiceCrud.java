package CURD;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import parlour.Client;
import parlour.Service;

public class ServiceCrud {
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
		sessionFactory.close();
		System.out.println("session factory closed");
	}
	public static boolean createService(Service s) {
		try {
			transaction = getTransaction();
			session.save(s);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println("createService :: "+e.getMessage());
		}
		return false;
	}
	public static Service getService(int serviceId) {
		Service s  = (Service)session.get(Service.class, serviceId);
		 return s;
	}
	public static Client getClient(int serviceId) {
		 Service s  = (Service)session.get(Service.class, serviceId);
		 return (Client) s.getClients();  
	} 
	public static boolean updateService(Service s) {
		try {
			transaction = session.beginTransaction();
			session.update(s);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println("redord not updated!");
		}
		return false; 
	}
	
	public static boolean deleteService(Service s) {
		try {
			
			transaction = session.beginTransaction();
			session.delete(s);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public static ArrayList<Service> getAllServices() {
		try {
			Query query = session.createQuery("from Serices");
			ArrayList<Service> service = (ArrayList<Service>) query.list();
			return service;

		} catch (Exception e) {
			System.out.println("getAllCouses::" + e.getMessage());
		}
		return null;
	}
}