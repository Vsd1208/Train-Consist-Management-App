import java.util.*;
import java.util.stream.*;

// Main class
public class UseCase8_TrainConsist {

    // Reusing Bogie model from UC7
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
            System.out.println("Bogie Name: " + name + ", Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC8: Filter Passenger Bogies Using Streams ");
        System.out.println("======================================");

        // Create list of passenger bogies (same as UC7)
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("B1", 72));
        bogies.add(new Bogie("B2", 50));
        bogies.add(new Bogie("B3", 90));
        bogies.add(new Bogie("B4", 60));
        bogies.add(new Bogie("B5", 40));

        // Display all bogies
        System.out.println("\nAll Bogies:");
        bogies.forEach(b -> b.display());

        // Filter bogies with capacity >= 60 using Stream API
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity >= 60)
                .collect(Collectors.toList());

        // Display filtered bogies
        System.out.println("\nFiltered Bogies (Capacity >= 60):");
        filteredBogies.forEach(b -> b.display());
    }
}