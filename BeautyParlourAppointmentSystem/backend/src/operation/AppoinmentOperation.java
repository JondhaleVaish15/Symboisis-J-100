package operation;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import CURD.AppoinmentCrud;
import parlour.Appoinment;
import parlour.Client;
import parlour.Service;

public class AppoinmentOperation {
    static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    public static void CreateAppoinment() {
        try {
            // Getting client and service IDs
            System.out.println("Enter Client ID:");
            int clientId = scan.nextInt();
            System.out.println("Enter Service ID:");
            int serviceId = scan.nextInt();

            // Consume the newline character left by nextInt()
            scan.nextLine();  // This ensures nextLine() works properly for date and time input

            // Getting Appointment Date
            System.out.println("Enter a date (YYYY-MM-DD): ");
            String AppoinmentDate = scan.nextLine();
            LocalDate date = LocalDate.parse(AppoinmentDate);  // Parse the date
            java.sql.Date.valueOf(date);
            // Getting Appointment Time
            System.out.println("Enter a Appoinment time : ");
            String AppoinmentTime = scan.next();
           
            //LocalTime time = LocalTime.parse(AppoinmentTime);  // Parse the time
            
            // Fetching client and service objects
            Client client = AppoinmentCrud.getClientById(clientId);
            Service service = AppoinmentCrud.getServiceById(serviceId);

            if (client == null) {
                System.out.println("Client with ID " + clientId + " does not exist.");
                return;
            }
            if (service == null) {
                System.out.println("Service with ID " + serviceId + " does not exist.");
                return;
            }

            // Creating Appointment object
            Appoinment app = new Appoinment();
            app.setClient(client);
            app.setService(service);
            app.setAppointmentDate(java.sql.Date.valueOf(date));  // Set the parsed date
            app.setAppointmentTime(AppoinmentTime);  // Set the parsed time
            app.setAppointmentStatus("Confirmed");

            // Inserting Appointment into the database
            boolean appoinmentCreated = AppoinmentCrud.insertAppoinment(app);
            if (appoinmentCreated) {
                System.out.println("Appointment created successfully!");
            } else {
                System.out.println("Failed to create Appointment.");
                return;
            }

        } catch (Exception e) {
            System.out.println("Error creating Appointment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void CancleBooking() {
        try {
            System.out.println("Enter Appointment id:");
            int AppoinmentId = scan.nextInt();
            Appoinment a = AppoinmentCrud.getAppoinment(AppoinmentId);
            if (a != null) {
                boolean isDeleted = AppoinmentCrud.CancleAppoinment(a);

                if (isDeleted) {
                    System.out.println("Appointment has been successfully canceled.");
                } else {
                    System.out.println("Failed to cancel the Appointment.");
                }
            } else {
                System.out.println("Appointment record not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: Could not delete the record!");
            e.printStackTrace();
        }
    }

    public static void ReadAppoinment() {
        try {
            System.out.println("Enter Appointment Id:");
            Appoinment a = AppoinmentCrud.getAppoinment(scan.nextInt());
            if (a != null) {
                System.out.println("----Appointment details----");
                System.out.println("Appointment Id: " + a.getAppointmentId());
                System.out.println("Appointment Status: " + a.getAppointmentStatus());
                System.out.println("Appointment Date: " + a.getAppointmentDate());
                System.out.println("Appointment Time: " + a.getAppointmentTime());
                System.out.println("Client having Appointment: ");
                System.out.println("---------------------------------");
                System.out.println("Client details: " + a.getClient());
                System.out.println("Services Taken by the Client: ");
                System.out.println("---------------------------------");
                System.out.println("Service details: " + a.getService());
            }
        } catch (Exception e) {
            System.out.println("Appointment data not found!");
        }
    }
}
