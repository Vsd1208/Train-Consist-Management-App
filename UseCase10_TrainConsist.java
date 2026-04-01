import java.util.*;
import java.util.stream.*;

// Main class
public class UseCase10_TrainConsist {

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
        System.out.println(" UC10: Count Total Seats in Train ");
        System.out.println("======================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            b.display();
        }

        // AGGREGATE USING REDUCE
        // map() extracts capacity from Bogie
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, (sum, cap) -> sum + cap);

        // Display total seats
        System.out.println("\nTotal Seating Capacity: " + totalSeats);
    }
}