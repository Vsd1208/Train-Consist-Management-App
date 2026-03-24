import java.util.LinkedList;
import java.util.List;

public class UseCase4TrainConsistAgent {

    public static void main(String[] args) {

        System.out.println("-------------------------------");
        System.out.println(" UC4 Maintain Ordered Bogie Consist ");
        System.out.println("-------------------------------\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts/removals
        List<String> trainConsist = new LinkedList<>();

        // =========================
        // ADD bogies in sequence
        // =========================
        trainConsist.add("BG101");
        trainConsist.add("BG102");
        trainConsist.add("BG103");

        System.out.println("After adding bogies: " + trainConsist);

        // =========================
        // INSERT bogies at specific positions
        // =========================
        trainConsist.add(1, "BG101A"); // insert at position 1
        System.out.println("After inserting at position 1: " + trainConsist);

        // =========================
        // REMOVE bogies from front and rear
        // =========================
        trainConsist.remove(0); // remove first bogie
        trainConsist.remove(trainConsist.size() - 1); // remove last bogie

        System.out.println("After removing first and last bogie: " + trainConsist);

        // =========================
        // DISPLAY final train structure
        // =========================
        System.out.println("\nFinal train consist: " + trainConsist);
    }
}