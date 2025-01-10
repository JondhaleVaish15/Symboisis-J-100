package parlour;
import java.util.Scanner;

import operation.AppoinmentOperation;
import operation.ClientOperation;
import operation.ServiceOperation; 

public class Driver {
	static Scanner scan;
	static {
		scan = new Scanner(System.in);
	}
  public static int MainMenu() {
	  try {
		  int choice;
	  System.out.println( "\n\n  Welcome to the Parlour appointment System"
	  		         + "\n----Main Menu---\n 1.Client operations \n 2.Service operations \n 3.Appoinment Operations"
	  		         + "\n 4.exit \n Please select an option:");
	  return choice=scan.nextInt();
	  }
	  catch (Exception e) { 
		System.out.println("your choice is not accepted!");
	}
	  return -1;
  }
  public static int ClientMenu() {
	  try {
	  int choice;
	  System.out.println("\n 1.Insert Client Data \n 2.Update Client Data \n 3.Delete client data"
	  		+ "\n 4.Read client data"
	  		+ "\n5.Exit \n -----select option----");
	   return choice=scan.nextInt();
	  }
	  catch (Exception e) {
		  System.out.println("your choice is not accepted!");
	}
	  return -1;
  }
  public static int ServiceMenu() {
	  try {
		  int choice;
		  System.out.println("\n 1.Insert Service Data \n 2.Update Service Data \n 3.Delete Service data"
		  		+ "\n 4.Read Service data \n 5. get client by Service Id"
		  		+ "\n6.Exit \n -----select option----");
		   return choice=scan.nextInt();
		  }
		  catch (Exception e) {
			  System.out.println("your choice is not accepted!");
		}
		  return -1;
  }
  public static int AppoinmentMenu() {
	  try {
		  int choice;
		  System.out.println("\n 1.Create Appoinment \n 2.Cancle Appoinment \n 3.Read Appoinment"
		  		
		  		+ "\n4.Exit \n -----select option----");
		   return choice=scan.nextInt();
		  }
		  catch (Exception e) {
			  System.out.println("your choice is not accepted!");
		}
		  return -1;
  }
  
  public static void main(String [] arg) {
	  char mainChar = 'n';
	 do {
	 switch(MainMenu()) {
	 case 1:
		 char ClientChar='n';
		 do {
			 switch(ClientMenu()) {
			 case 1:
					char ch = 'y';
					do {	
						ClientOperation.InsertClientData();
						System.out.println("Add Another Client (y/n)");
						ch = Character.toUpperCase(scan.next().charAt(0));
					} while (ch == 'Y' || ch=='y');
					break;
				case 2:
					ClientOperation.UpdateClientRecord();
					break;
				case 3:
				    ClientOperation.DeleteClientRecord();
					break;
				case 4:        
				   ClientOperation.ReadClientData();
				  break;
                default:
                	System.out.println("Invalid option!");
			 } 
		  }while (ClientChar == 'Y');
	 case 2:
		 char ServiceChar='n';
		 do {
			 switch(ServiceMenu()) {
			 case 1:
					char ch = 'y';
					do {	
						ServiceOperation.InsertServiceData();
						System.out.println("Add Another Service (y/n)");
						ch = Character.toUpperCase(scan.next().charAt(0));
					} while (ch == 'Y' || ch=='y');
					break;
				case 2:
					ServiceOperation.UpdateServiceRecord();
					break;
				case 3:
					ServiceOperation.DeleteServiceRecord();
					break;
				case 4:        
					ServiceOperation.ReadServiceData();
				  break;
				case 5:
					ServiceOperation.getClientByServiceId();
					break;
                default:
                	System.out.println("Invalid option!");
			 } 
		   }while (ServiceChar == 'Y');
	 case 3:
		 char AppoinmentChar='n';
		 do {
			 switch(AppoinmentMenu()) {
			 case 1:
					char ch = 'y';
					do {	
						AppoinmentOperation.CreateAppoinment();
						System.out.println("Add Another Service (y/n)");
						ch = Character.toUpperCase(scan.next().charAt(0));
					} while (ch == 'Y' || ch=='y');
					break;
				case 2:
					AppoinmentOperation.CancleBooking();
					break;
				case 3:
					AppoinmentOperation.ReadAppoinment();
					break;
				
                default:
                	System.out.println("Invalid option!");
			 } 
		   }while (AppoinmentChar == 'Y');
		 }
		 
		 
	 
	 }while(mainChar=='n');
  }
  
}