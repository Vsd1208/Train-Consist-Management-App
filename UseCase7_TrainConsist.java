import java.util.*;
public class UseCase7_TrainConsist {
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
        void display() {
            System.out.println("Bogie Name: " + name + ", Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC7: Sort Bogies by Capacity ");
        System.out.println("======================================");
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("B1", 72));
        bogies.add(new Bogie("B2", 50));
        bogies.add(new Bogie("B3", 90));
        bogies.add(new Bogie("B4", 60));

        // Display unsorted data
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            b.display();
        }

        // Sort using Comparator (by capacity)
        Collections.sort(bogies, new Comparator<Bogie>() {
            @Override
            public int compare(Bogie b1, Bogie b2) {
                return b1.capacity - b2.capacity; // ascending order
            }
        });

        // Display sorted data
        System.out.println("\nAfter Sorting (by Capacity):");
        for (Bogie b : bogies) {
            b.display();
        }
    }
}