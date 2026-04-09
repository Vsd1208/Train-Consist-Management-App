public class UseCase18TrainConsistigant {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC18 Linear Search for Bogie ID ");
        System.out.println("=======================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search
        String searchId = "BG309";

        // Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        // LINEAR SEARCH LOGIC

        boolean found = false;

        // Traverse each element sequentially
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break; // stop when match is found
            }
        }

        // Display result
        System.out.println("\n\nSearching for Bogie ID: " + searchId);

        if (found) {
            System.out.println("Result: Bogie ID FOUND ");
        } else {
            System.out.println("Result: Bogie ID NOT FOUND ");
        }
    }
}