import java.util.Scanner;

public class LogisticManagementSystem {
    static Scanner sc = new Scanner (System.in);
    static String cities [] = new String [30];
    
    public static void main(String[] args) {
        
        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    manageCities();
                    break;
                case 2:
                    manageDistances();
                    break;
                case 3:
                    handleDeliveries();
                    break;
                case 4:
                    viewReports();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice!=5);
    }

    public static void printMenu(){
        System.out.println("\n===== Logistics Management System =====");
            System.out.println("1. Manage Cities");
            System.out.println("2. Manage Distances");
            System.out.println("3. Handle Deliveries");
            System.out.println("4. View Reports");
            System.out.println("5. Exit");
                        
    }

    public static void manageCities(){
        


    }

    public static void manageDistances(){

    }

    public static void handleDeliveries(){

    }

    public static void viewReports(){

    }



}
