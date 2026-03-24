import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5TrainConsistAgent {

    public static void main(String[] args) {

        System.out.println("----------------------------------------");
        System.out.println(" UC5 Preserve Insertion Order of Bogies ");
        System.out.println("----------------------------------------\n");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // =========================
        // ADD bogies (with duplicates)
        // =========================
        formation.add("BG101");
        formation.add("BG102");
        formation.add("BG103");
        formation.add("BG104");

        // Duplicate entries (ignored automatically)
        formation.add("BG102");
        formation.add("BG101");

        // =========================
        // DISPLAY final formation
        // =========================
        System.out.println("Final train formation (ordered & unique):");
        for (String bogie : formation) {
            System.out.println(bogie);
        }

        // =========================
        // COUNT
        // =========================
        System.out.println("\nTotal bogies: " + formation.size());
    }
}