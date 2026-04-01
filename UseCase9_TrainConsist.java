import java.util.*;
import java.util.stream.*;

// Main class
public class UseCase9_TrainConsist {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        // Constructor
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        // Display method
        void display() {
            System.out.println("Bogie Type: " + name + ", Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC9: Group Bogies by Type ");
        System.out.println("======================================\n");

        // Create List of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 78));
        bogies.add(new Bogie("AC Chair", 60));

        // Display input bogies
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            b.display();
        }

        // GROUP USING COLLECTORS.groupingBy()
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        // Display grouped structure
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {

            System.out.println("\nType: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                b.display();
            }
        }
    }
}