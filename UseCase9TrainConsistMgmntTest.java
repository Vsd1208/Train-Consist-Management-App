import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmntTest {

    // Bogie class (same as UC8)
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Helper method for filtering
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity >= threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 70),
                new Bogie("B2", 50)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertEquals(1, result.size());
        assertEquals(70, result.get(0).capacity);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 60),
                new Bogie("B2", 50)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertEquals(1, result.size());
        assertEquals(60, result.get(0).capacity);
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 40),
                new Bogie("B2", 50)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 70),
                new Bogie("B2", 80),
                new Bogie("B3", 50)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 30),
                new Bogie("B2", 40)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 70),
                new Bogie("B2", 80)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", 70));
        bogies.add(new Bogie("B2", 40));

        int originalSize = bogies.size();

        filterBogies(bogies, 60);

        // Ensure original list not modified
        assertEquals(originalSize, bogies.size());
    }
}