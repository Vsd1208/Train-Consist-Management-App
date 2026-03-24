import java.util.HashMap;
import java.util.Map;

public class UseCase6TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("--------------------------------------------");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("--------------------------------------------\n");

        // HashMap stores data in key -> value format
        // Key = Bogie ID, Value = Capacity
        Map<String, Integer> capacityMap = new HashMap<>();

        // =========================
        // INSERT bogie capacities
        // =========================
        capacityMap.put("BG101", 72);
        capacityMap.put("BG102", 68);
        capacityMap.put("BG103", 80);
        capacityMap.put("BG104", 75);

        // Updating capacity (same key will overwrite)
        capacityMap.put("BG102", 70);

        // =========================
        // DISPLAY all entries
        // =========================
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println("Bogie ID: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        // =========================
        // LOOKUP example
        // =========================
        String searchKey = "BG103";
        if (capacityMap.containsKey(searchKey)) {
            System.out.println("\nCapacity of " + searchKey + " is: "
                    + capacityMap.get(searchKey));
        } else {
            System.out.println("\nBogie not found.");
        }

        // =========================
        // TOTAL bogies
        // =========================
        System.out.println("\nTotal bogies mapped: " + capacityMap.size());
    }
}