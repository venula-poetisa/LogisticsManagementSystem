import java.io.*;

public class FileHandling {

    // Save cities and distances
    public static void saveCitiesAndDistances(String[] cities, int cityCount, int[][] distance) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("routes.txt"));
            writer.println(cityCount);
            for (int i = 0; i < cityCount; i++) {
                writer.println(cities[i]);
            }
            for (int i = 0; i < cityCount; i++) {
                for (int j = 0; j < cityCount; j++) {
                    writer.print(distance[i][j] + " ");
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving routes: " + e.getMessage());
        }
    }

    // Load cities and distances
    public static int loadCitiesAndDistances(String[] cities, int[][] distance) {
        int cityCount = 0;
        try {
            File file = new File("routes.txt");
            if (!file.exists()) return 0;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            cityCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < cityCount; i++) {
                cities[i] = reader.readLine();
            }

            for (int i = 0; i < cityCount; i++) {
                String[] parts = reader.readLine().split(" ");
                for (int j = 0; j < cityCount; j++) {
                    distance[i][j] = Integer.parseInt(parts[j]);
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading routes: " + e.getMessage());
        }
        return cityCount;
    }

    // Save deliveries
    public static void saveDeliveries(String[] deliFrom, String[] deliTo, double[] deliCost, int deliCount) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("deliveries.txt"));
            writer.println(deliCount);
            for (int i = 0; i < deliCount; i++) {
                writer.println(deliFrom[i] + "," + deliTo[i] + "," + deliCost[i]);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving deliveries: " + e.getMessage());
        }
    }

    // Load deliveries
    public static int loadDeliveries(String[] deliFrom, String[] deliTo, double[] deliCost) {
        int deliCount = 0;
        try {
            File file = new File("deliveries.txt");
            if (!file.exists()) return 0;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            deliCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < deliCount; i++) {
                String[] parts = reader.readLine().split(",");
                deliFrom[i] = parts[0];
                deliTo[i] = parts[1];
                deliCost[i] = Double.parseDouble(parts[2]);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading deliveries: " + e.getMessage());
        }
        return deliCount;
    }
}
