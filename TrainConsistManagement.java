import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS UseCase1: TrainConsistManagement
 *
 * Description:
 * Entry point of the Train Consist Management Application.
 * Initializes an empty train consist using a dynamic list,
 * displays initial bogie count, and prints current state.
 *
 * @author Deve Loper
 * @version 2.0
 */
public class TrainConsistManagement {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("==================================");
        System.out.println(" Train Consist Management App");
        System.out.println("==================================\n");

        // Create a dynamic List to store train bogies
        List<String> trainConsist = new ArrayList<>();

        // Display initial consist information
        System.out.println("Train initialized successfully...");

        // Display initial bogie count
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // Print current state of the train
        System.out.println("Current train consist: " + trainConsist);
    }
}