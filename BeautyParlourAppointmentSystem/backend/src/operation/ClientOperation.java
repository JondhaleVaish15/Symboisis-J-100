package operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CURD.ClientCrud;
import CURD.ServiceCrud;
import parlour.Client;
import parlour.Service;

public class ClientOperation {
	static Scanner scan;
	static {
		scan = new Scanner(System.in);
	}
	public static void InsertClientData() {
		try {
		Client c=new Client();
		System.out.println("Enter client name:");
		c.setClientName(scan.next());
		System.out.println("Enter client mobile no");
		c.setClientMobileno(scan.nextLong());
		System.out.println("Enter client Password");
		c.setClientPassword(scan.next());
		System.out.println("Enter client role");
		c.setClientRole(scan.next()); 
		System.out.println("Enter client Email"); 
		c.setClientEmail(scan.next());

		if(ClientCrud.CreateClient(c)) {
			System.out.println("records inserted successfully!");
		}
		
		}
		catch (Exception e) {
			System.out.println("records are not inserted!");
		}
	}
	
	public static void ReadClientData() {
		try {

		System.out.println("Enter Client Id");
		Client c=ClientCrud.getClient(scan.nextInt());
		if(c!=null) {
		  System.out.println("----client details----");
		  System.out.println("Client Id :"+c.getClientId());
		  System.out.println("Client Name: "+c.getClientName());
		  System.out.println("Client Email ID:" +c.getClientEmail());
		  System.out.println("Client Role: "+c.getClientRole());
		  System.out.println("---------------------------------");
		} 
		for (Service service : c.getServices()) {
            System.out.println("Service name: " + service.getServiceName());
            System.out.println("Service type: " + service.getServiceType());
            System.out.println("Service price: " + service.getServicePrice());
            System.out.println("---------------------------------");
        }
		}
		 catch (Exception e) {
			System.out.println("Client not found!");
		}
	}
	
	public static void UpdateClientRecord() {
		System.out.println("Enter Client Id : ");
		try {
			int ClientId = scan.nextInt();
			Client client = ClientCrud.getClient(ClientId);
			if (client != null) {
				System.out
						.println("\n1. Update Client Name " + "\n2. Update Client mobile no " + "\n3Update Client Email " + "\n4.Update Client Role " + "\nEnter Choice : ");
				switch(scan.nextInt()) {
			
				case 1:
					System.out.println("Enter New Client Name : ");
					client.setClientName(scan.next());
					if(ClientCrud.UpdateClientRecord(client))
						System.out.println("Client Name updated Successfully...");
					break;
				
				case 2:
					System.out.println("Enter New Mobile no : ");
					client.setClientMobileno(scan.nextInt());
					if(ClientCrud.UpdateClientRecord(client))
						System.out.println("Client mobile no updated Successfully...");
					break;
			
				case 3:
					System.out.println("Enter New Email : ");
					client.setClientEmail(scan.next());
					if(ClientCrud.UpdateClientRecord(client))
						System.out.println("Email updated Successfully...");
					break;
				case 4:
					System.out.println("Enter Client role : ");
					client.setClientRole(scan.next());
					if(ClientCrud.UpdateClientRecord(client))
						System.out.println("Client role updated Successfully...");
					break;
					default:
						System.out.println("Invalid Input...");
				}
				
			}else {
				System.err.println("Record Not Found");
			}
		} catch (Exception e) {
			System.err.println("updateClient:: " + e.getMessage());
		}

	}
	public static void DeleteClientRecord() {
		try {
			System.out.println("Enter client id:");
			int ClientId = scan.nextInt();
			Client c = ClientCrud.getClient(ClientId);
			if(c != null) {
				if(ClientCrud.deleteClient(c)) {
					System.out.println("Record Deleted");
				}else {
					System.out.println("something want wrong");
				}
			}else {
				System.out.println("Record Not Found");
			}
		} catch (Exception e) {
			System.out.println("records are not deleted!");		
			}
	}
	

}