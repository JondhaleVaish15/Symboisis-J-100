package operation;

import java.util.Scanner;

import CURD.ServiceCrud;
import parlour.Client;
import parlour.Service;

public class ServiceOperation {
	static Scanner scan;
	static {
		scan = new Scanner(System.in);
	}

	public static void InsertServiceData() {
		try {
			Service s = new Service();
			System.out.print("\nEnter Service Name : ");
			s.setServiceName(scan.nextLine());
			System.out.print("Enter Service Type : ");
			s.setServiceType(scan.nextLine());
			System.out.print("Enter Service price : ");
			s.setServicePrice(scan.nextDouble());
			if (ServiceCrud.createService(s))
				System.out.println("record inserted");
			else
				System.err.println("record not inserted");
		} catch (Exception e) {
			// TODO: handle exception
			scan.next();
		}
	} 

	public static void ReadServiceData() {
		try {
			System.out.print("Enter Service Id : ");
			Service s = ServiceCrud.getService(scan.nextInt());
			if (s != null) {
				System.out.println("\n-- Course Details --");
				System.out.println("Service Id : " + s.getServiceId());
				System.out.println("Service Name : " + s.getServiceName());
				System.out.println("Service Type : " + s.getServiceType());
				System.out.println("Service Price : " + s.getServicePrice());
				System.out.println("-- Enroled Client --");
				for (Client client : s.getClients()) {
				    System.out.println("Client Email: " + client.getClientEmail());
				    System.out.println("Client ID: " + client.getClientId());
				    System.out.println("Client Mobile No: " + client.getClientMobileno());
				    System.out.println("Client Name: " + client.getClientName());
				    System.out.println("Client Role: " + client.getClientRole());
				}
			} else {
				System.err.println("Record not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void UpdateServiceRecord() {
		System.out.println("Enter Service Id : ");
		try {
			int ServiceId = scan.nextInt();
			Service s = ServiceCrud.getService(ServiceId);
			if (s != null) {
				System.out.println("\n1. Update Service Name " + "\n 2. Update Service Type " + "\n 3. Update Service price " + "\nEnter Choice : ");
				switch(scan.nextInt()) {
			
				case 1:
					System.out.println("Enter New Service Name : ");
					s.setServiceName(scan.next());
					if(ServiceCrud.updateService(s))
						System.out.println("Service Name updated Successfully...");
					break;
				
				case 2:
					System.out.println("Enter New Service type : ");
					s.setServiceType(scan.next());
					if(ServiceCrud.updateService(s))
						System.out.println("Service Type updated Successfully...");
					break;
				
				case 3:
					System.out.println("Enter New Service price : ");
					s.setServicePrice(scan.nextInt());
					if(ServiceCrud.updateService(s))
						System.out.println("Informations updated Successfully...");
					break;
					default:
						System.out.println("Invalid Input...");
					
				}
				
			}else {
				System.err.println("Record Not Found");
			}
		} catch (Exception e) {
			System.err.println("updateService:: " + e.getMessage());
		}

	}
	public static void DeleteServiceRecord() {
		System.out.println("Enter Service Id : ");
		int ServiceId = scan.nextInt();
		Service s = ServiceCrud.getService(ServiceId);
		if(s!= null) {
			if(ServiceCrud.deleteService(s)) {
				System.out.println("Record Deleted");
			}else {
				System.out.println("something want wrong");
			}
		}else {
			System.out.println("Record Not Found");
		}
	}

	public static void getClientByServiceId() {
	    System.out.print("Enter Service Id: ");
	    int serviceId = scan.nextInt();
	    Client client = ServiceCrud.getClient(serviceId);
	    if ( client != null) {
	        System.out.println("Service enrolled by " + client.getClientName() + ":");
	        for (Service service  : client.getServices()) {
	            System.out.println("Client Name: " + client.getClientName());
	            System.out.println("Client Email Id: " + client.getClientEmail());
	            System.out.println("----------------------------");
	        }
	    } else {
	        System.out.println("Client not found!");
	    }
	}

}