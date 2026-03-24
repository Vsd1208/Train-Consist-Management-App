import java.util.ArrayList;
import java.util.List;

public class UseCase2TrainConsist {

    public static void main(String[] args) {

        System.out.println("---------------*************");
        System.out.println(" UC2 Add Passenger Bogies to Train ");
        System.out.println("---------------\n");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // =========================
        // CREATE (Add bogies)
        // =========================
        // add() attaches a new bogie to the train
        passengerBogies.add("Bogie-1");
        passengerBogies.add("Bogie-2");
        passengerBogies.add("Bogie-3");

        System.out.println("After adding bogies: " + passengerBogies);

        // =========================
        // READ (Display bogies)
        // =========================
        System.out.println("Total number of bogies: " + passengerBogies.size());

        // =========================
        // UPDATE (Modify bogie)
        // =========================
        passengerBogies.set(1, "Bogie-2A"); // updating second bogie
        System.out.println("After updating bogie: " + passengerBogies);

        // =========================
        // DELETE (Remove bogie)
        // =========================
        passengerBogies.remove("Bogie-1");
        System.out.println("After removing Bogie-1: " + passengerBogies);

        // =========================
        // CHECK (Availability)
        // =========================
        if (passengerBogies.contains("Bogie-3")) {
            System.out.println("Bogie-3 is available in the train.");
        } else {
            System.out.println("Bogie-3 is NOT available.");
        }

        // =========================
        // FINAL CONSIST
        // =========================
        System.out.println("\nFinal train consist: " + passengerBogies);
    }
}