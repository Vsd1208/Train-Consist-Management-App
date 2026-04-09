import java.util.Arrays;

public class UseCase17TrainConsistMgant {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC17 Sorting using Arrays.sort() ");
        System.out.println("=======================================\n");

        // Create array of bogie names
        String[] bogieNames = {"Sleeper", "General", "AC", "Luxury", "ChairCar"};

        // Display original order
        System.out.println("Original Bogie Names:");
        for (String name : bogieNames) {
            System.out.print(name + " ");
        }

        // Sort using built-in method
        Arrays.sort(bogieNames);

        // Display sorted result
        System.out.println("\n\nSorted Bogie Names (Alphabetical):");
        for (String name : bogieNames) {
            System.out.print(name + " ");
        }
    }
}