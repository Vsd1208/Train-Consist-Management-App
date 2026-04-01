import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UseCase12TrainConsistMgmntTest {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Same safety logic
    private boolean isSafe(GoodsBogie b) {
        if (b.type.equalsIgnoreCase("Cylindrical")) {
            return b.cargo.equalsIgnoreCase("Liquid");
        }
        return true;
    }

    private boolean checkSafety(List<GoodsBogie> list) {
        return list.stream().allMatch(this::isSafe);
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Liquid"),
                new GoodsBogie("Box", "Solid")
        );

        assertTrue(checkSafety(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Solid")
        );

        assertFalse(checkSafety(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Box", "Liquid"),
                new GoodsBogie("Flatbed", "Gas")
        );

        assertTrue(checkSafety(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Liquid"),
                new GoodsBogie("Cylindrical", "Solid") // violation
        );

        assertFalse(checkSafety(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(checkSafety(list)); // allMatch on empty = true
    }
}