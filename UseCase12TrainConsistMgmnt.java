import java.util.*;
import java.util.stream.*;
public class UseCase12TrainConsistMgmnt {

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        void display() {
            System.out.println("Type: " + type + ", Cargo: " + cargo);
        }
    }

    // Safety rule:
    // If type = "Cylindrical", cargo must be "Liquid"
    public static boolean isSafe(GoodsBogie b) {
        if (b.type.equalsIgnoreCase("Cylindrical")) {
            return b.cargo.equalsIgnoreCase("Liquid");
        }
        return true; // other types are allowed
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC12: Safety Compliance Check ");
        System.out.println("======================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Liquid"));
        goodsBogies.add(new GoodsBogie("Box", "Solid"));
        goodsBogies.add(new GoodsBogie("Flatbed", "Machinery"));

        // Display bogies
        System.out.println("Goods Bogies:");
        goodsBogies.forEach(b -> b.display());

        // Check safety using allMatch()
        boolean isAllSafe = goodsBogies.stream()
                .allMatch(b -> isSafe(b));

        // Display result
        System.out.println("\nSafety Status: " +
                (isAllSafe ? "All Bogies are SAFE ✅" : "Safety VIOLATION ❌"));
    }
}