public class UseCase20TrainConsistgant {

    // Search method with fail-fast validation
    public static boolean searchBogie(String[] bogieIds, String searchId) {

        // FAIL-FAST VALIDATION
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Train has no bogies. Search cannot be performed.");
        }

        // SEARCH LOGIC
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC20 Exception Handling During Search ");
        System.out.println("=======================================\n");

        // Create bogie array (empty train scenario)
        String[] bogieIds = {};

        // Search key
        String searchId = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchId);

            // Display result
            if (found) {
                System.out.println("Result: Bogie FOUND ");
            } else {
                System.out.println("Result: Bogie NOT FOUND ");
            }

        } catch (IllegalStateException e) {
            // Handle fail-fast exception
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");
    }
}