import java.util.*;

/**
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 */
public class UseCase14TrainConsistMgmnt {

    // CUSTOM EXCEPTION
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model with validation
    static class PassengerBogie {
        String name;
        int capacity;

        PassengerBogie(String name, int capacity) throws InvalidCapacityException {

            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than 0");
            }

            this.name = name;
            this.capacity = capacity;
        }

        void display() {
            System.out.println("Bogie: " + name + ", Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC14: Custom Exception Handling ");
        System.out.println("======================================\n");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            bogies.add(new PassengerBogie("B1", 72));
            bogies.add(new PassengerBogie("B2", 50));

            // This will throw exception
            bogies.add(new PassengerBogie("B3", -10));

        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Continue execution safely
        System.out.println("\nValid Bogies:");
        for (PassengerBogie b : bogies) {
            b.display();
        }
    }
}