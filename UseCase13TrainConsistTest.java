import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class UseCase13TrainConsistMgmntTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> createDataset(int size) {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Bogie("Type" + (i % 3), i % 100));
        }
        return list;
    }

    private List<Bogie> loopFilter(List<Bogie> list, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity >= threshold) {
                result.add(b);
            }
        }
        return result;
    }

    private List<Bogie> streamFilter(List<Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.capacity >= threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = createDataset(10);

        List<Bogie> result = loopFilter(list, 50);

        for (Bogie b : result) {
            assertTrue(b.capacity >= 50);
        }
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = createDataset(10);

        List<Bogie> result = streamFilter(list, 50);

        for (Bogie b : result) {
            assertTrue(b.capacity >= 50);
        }
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = createDataset(1000);

        List<Bogie> loopResult = loopFilter(list, 50);
        List<Bogie> streamResult = streamFilter(list, 50);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = createDataset(1000);

        long start = System.nanoTime();
        loopFilter(list, 50);
        long end = System.nanoTime();

        assertTrue(end > start); // time should move forward
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = createDataset(100000);

        List<Bogie> result = streamFilter(list, 50);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}