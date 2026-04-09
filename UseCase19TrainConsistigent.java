import java.util.Arrays;

public class UseCase19TrainConsistigent {

    // Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {

        // Handle empty array
        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        // Ensure array is sorted (precondition)
        Arrays.sort(bogieIds);

        int left = 0;
        int right = bogieIds.length - 1;

        // Binary Search Logic
        while (left <= right) {
            int mid = (left + right) / 2;

            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Found
            } else if (comparison < 0) {
                right = mid - 1; // Search left half
            } else {
                left = mid + 1; // Search right half
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC19 Binary Search for Bogie ID ");
        System.out.println("=======================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search key
        String key = "BG309";

        // Display sorted bogies
        Arrays.sort(bogieIds);
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        // Perform search
        boolean found = binarySearch(bogieIds, key);

        // Display result
        System.out.println("\n\nSearching for: " + key);
        if (found) {
            System.out.println("Result: FOUND ✅");
        } else {
            System.out.println("Result: NOT FOUND ❌");
        }
    }
}