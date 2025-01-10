package CURD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import parlour.Appoinment;
import parlour.Client;
import parlour.Service;

public class AppoinmentCrud {
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
    public static boolean insertAppoinment(Appoinment appoinment) {
    	try {
		session=getSession();
		transaction=getTransaction();
		session.save(appoinment);
		transaction.commit();
		return true;
    	}
    	catch (Exception e) {
			System.out.println("Error creating Appoinment: " + e.getMessage());
		}
    	return false;
	} 
    
    public static Client getClientById(int clientId) {
        Client client = (Client) session.get(Client.class, clientId);

        return client;
    }
	public static Service getServiceById(int serviceId) {
		Service service=(Service) session.get(Service.class,serviceId);
		return service;
	}
	
	public static Appoinment getAppoinment(int AppoinmentId) {
		Appoinment a= (Appoinment) session.get(Appoinment.class,AppoinmentId);
		 Client client = (Client) session.get(Client.class, AppoinmentId);
		 a.setClient(client); // Populate client details
		      Service service = (Service) session.get(Service.class, AppoinmentId);
			a.setService(service);
			
		return a;
	}
	
	public static boolean CancleAppoinment(Appoinment app) {
		try {
		transaction =session.beginTransaction();
		session.delete(app);
		transaction.commit();
		return true;
		}
		catch (Exception e) {
			e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
	   }
	}
}