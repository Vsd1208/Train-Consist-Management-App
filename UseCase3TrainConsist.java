import java.util.HashSet;
import java.util.Set;

public class UseCase3TrainConsist {

    public static void main(String[] args) {

        System.out.println("----------------------------");
        System.out.println(" UC3 Track Unique Bogie IDs ");
        System.out.println("----------------------------\n");

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogies = new HashSet<>();

        // =========================
        // ADD IDs (including duplicates)
        // =========================
        // add() inserts bogie IDs into the set
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // Duplicate entries (will be ignored automatically)
        bogies.add("BG101"); // Duplicate
        bogies.add("BG102"); // Duplicate

        // =========================
        // DISPLAY UNIQUE BOGIES
        // =========================
        System.out.println("Unique Bogie IDs:");
        for (String bogie : bogies) {
            System.out.println(bogie);
        }

        // =========================
        // COUNT OF UNIQUE BOGIES
        // =========================
        System.out.println("\nTotal unique bogies: " + bogies.size());
    }
}