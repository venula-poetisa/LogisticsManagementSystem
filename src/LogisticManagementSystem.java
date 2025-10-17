import java.util.Scanner;

public class LogisticManagementSystem {
    static Scanner sc = new Scanner (System.in);
    static final int MAX_CITIES = 30;
    static String [] cities = new String [MAX_CITIES];
    static int cityCount = 0; //to maintain an easier array handling
    
    static int[][] distance = new int[MAX_CITIES][MAX_CITIES];
    //static int indexOfcity;
    
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
        System.out.println("\n\n===== Logistics Management System =====");
            System.out.println("1. Manage Cities");
            System.out.println("2. Manage Distances");
            System.out.println("3. Handle Deliveries");
            System.out.println("4. View Reports");
            System.out.println("5. Exit");
                        
    }

    public static void manageCities(){
        int option;
        do{
            System.out.println("\n\t1. Add a new city");
            System.out.println("\t2. Rename a city");
            System.out.println("\t3. Remove a city");
            System.out.println("\t4. Stop City Managing");

            System.out.print("\n\tSelect your choice: ");
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
        System.out.print("Enter the city to be renamed: ");
        String cityRename = sc.nextLine().toUpperCase();
        boolean found = false;
        
        for (int i=0; i<cityCount; i++){
            if (cities[i].equals(cityRename)){
                System.out.print("\nEnter the new city name: ");
                String newCity = sc.nextLine().toUpperCase();
                cities[i]=newCity;
                System.out.println("Renamed the city successfully!");
                found = true;
                break;
            }
            
        }
        if (!found) System.out.println("City not found!");
    }

    public static void removeCity(){
        System.out.print("Name of the city to be removed: ");
        String removeCity = sc.nextLine().toUpperCase();
        boolean found = false;

        for (int i=0; i<cityCount; i++){
            if (cities[i].equals(removeCity)){
                cities[i]= cities[cityCount-1];  //replacing with the last city to avoid null elements in the array
                cities[cityCount-1]="";
                cityCount--;

                System.out.println("Removed the city successfully!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("City not found!");

    }

    public static void manageDistances(){
        if (cityCount <2){
            System.out.println("There should be two cities.");
            return;
        }

        while (true){
            System.out.println("\n\t1. Add or Edit distance");
            System.out.println("\t2. Display distance table");
            System.out.println("\t3. Stop distance management");

            System.out.print("\tEnter your choice: ");
            int choice = sc.nextInt();

            if (choice ==1){
                System.out.println("\nAvailable cities: ");
                for (int i=0; i<cityCount; i++){
                    System.out.println(i+": "+ cities[i]);
                }
                System.out.print("\nEnter starting city index: ");
                int from = sc.nextInt();

                if (from<cityCount){
                    System.out.print("\nEnter destination city index: ");
                    int to = sc.nextInt();
                        if(to<cityCount){
                            if (from==to){
                            System.out.println("Distance from a city to itself is 0!");
                            distance [from][to]=0;
                            continue;
                            }

                        System.out.print("Enter distance in km: ");
                        int dist=sc.nextInt();

                        distance[from][to]=dist;
                        distance[to][from]=dist;
                        System.out.println("Distance updated successfully!");
                        }else{
                            System.out.println("Invalid city index!");
                        }
                }else{
                    System.out.println("Invalid city index!");
                }

            }else if(choice==2){
                System.out.println("\nDistance Table (km)");
                System.out.printf("%-15s","");
                for (int i = 0; i < cityCount; i++) {
                    System.out.printf("%-15s",cities[i]);
                }
            System.out.println();

            for (int i = 0; i < cityCount; i++) {
                System.out.printf("%-15s",cities[i]);
                for (int j = 0; j < cityCount; j++) {
                    System.out.printf("%-15s",distance[i][j]);
                }
                System.out.println();
            }
          }else if (choice ==3){
            return;
          }else{
            System.out.println("Invalid choice. Try again.");
          }
        }
    }

    public static void vehicleManagement(){
        final int VAN [] = {1000,30,60,12};
        final int TRUCK [] = {5000,40,50,6};
        final int LORRY []= {10000,80,45,4};

    }                                          

    public static void handleDeliveries(){

    }

    public static void viewReports(){
        for (int i=0; i<cityCount; i++){
                System.out.println(cities[i]);
            }

    }



}
