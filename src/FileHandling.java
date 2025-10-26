import java.io.*;

public class FileHandling {

    // Save cities and distances
    public static void saveCitiesAndDistances(String[] cities, int cityCount, int[][] distance) {
        try {
            FileWriter fw = new FileWriter("routes.txt");
            PrintWriter pw = new PrintWriter (fw);

            //first line keep how many cities are there
            pw.println(cityCount);

            //write city names one by one
            for (int i=0; i<cityCount; i++){
                pw.println(cities[i]);
            }

            //write 2D array of distances
            for (int i=0; i<cityCount; i++){
                for (int j=0; j<cityCount; j++){
                    pw.print(distance[i][j]+" ");
                }
                pw.println(); //to move to next line after each row
            }

            pw.close();
            fw.close();
            System.out.println("routes.txt saved successsfully!");
        }catch (IOException ex){
            System.out.println("Error saving routes: "+ex.getMessage());
        }
    }

    
    // Load cities and distances
    public static int loadCitiesAndDistances(String[] cities, int[][] distance) {
        int cityCount = 0;
        try {
            File f = new File("routes.txt");
            if (!f.exists()){
                System.out.println("No routes file yet...");
                return 0;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            cityCount = Integer.parseInt(br.readLine()); //first line has count

            //read city names
            for (int i = 0; i < cityCount; i++) {
                cities[i] = br.readLine();
            }

            //read distances
            for (int i = 0; i < cityCount; i++) {
                String[] parts = br.readLine().trim().split(" ");
                for (int j = 0; j < cityCount; j++) {
                    distance[i][j] = Integer.parseInt(parts[j]);
                }
            }

            br.close();
            System.out.println("routes.txt loaded ok");
        } catch (IOException e) {
            System.out.println("Error loading routes: " + e.getMessage());
        }
        return cityCount;
    }

    // Save deliveries (like history)
    public static void saveDeliveries(String[] deliFrom, String[] deliTo, double[] deliCost, int deliCount) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("deliveries.txt"));
            pw.println(deliCount); //first line has how many

            for (int i = 0; i < deliCount; i++) {
                pw.println(deliFrom[i] + "," + deliTo[i] + "," + deliCost[i]);
            }
            pw.close();
            System.out.println("Deliveries saved!");
        } catch (IOException e) {
            System.out.println("Error saving deliveries: " + e.getMessage());
        }
    }

    // Load deliveries history
    public static int loadDeliveries(String[] deliFrom, String[] deliTo, double[] deliCost) {
        int deliCount = 0;
        try {
            File f = new File("deliveries.txt");
            if (!f.exists()){
                System.out.println("No delivery file found!");
                return 0;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            deliCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < deliCount; i++) {
                String line = br.readLine();
                String[]data = line.split(",");
                deliFrom[i] = data[0];
                deliTo[i] = data[1];
                deliCost[i] = Double.parseDouble(data[2]);
            }

            br.close();
            System.out.println("Deliveries loaded successfully! (yay)");
        } catch (Exception e) {
            System.out.println("Error loading deliveries: " + e.getMessage());
        }
        return deliCount;
    }
}
