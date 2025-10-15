import java.util.Scanner;

public class LogisticManagementSystem {
    static Scanner sc = new Scanner (System.in);
    static String cities [] = new String [30];
    static int cityCount = 0;
    
    public static void main(String[] args) {
        
        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); //I used this to prevent unnecessary errors.
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
        int option;
        do{
            System.out.println("\n1. Add a new city");
            System.out.println("2. Rename a city");
            System.out.println("3. Remove a city");
            System.out.println("4. Stop City Managing");

            System.out.print("\nSelect your choice: ");
            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1:
                    addCity();
                    break;
                case 2:
                    renameCity();
                    break;
                case 3:
                    removeCity();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice.");

            }

        }while (option!=4);
    }

    public static void addCity(){

        if (cityCount >= cities.length) {
        System.out.println("City list is full!");   //if the user enters more than 30 cities
        return;
        }

        System.out.print("City Name: ");
        String city = sc.nextLine().toUpperCase();

        //to make sure the city is unique
        for (int i=0; i<cityCount; i++){
            if (cities[i].equals(city)){
                System.out.println("The city is already available");
                return;
            }
        }
        
        //storing the city in the array
        cities[cityCount] = city;
        cityCount++;

        System.out.println(city + " added successfully!");
    }

    public static void renameCity(){

    }

    public static void removeCity(){

    }

    public static void manageDistances(){

    }

    public static void handleDeliveries(){

    }

    public static void viewReports(){
        for (int i=0; i<cities.length; i++){
                System.out.println(cities[i]);
            }

    }



}
