import static org.junit.Assert.*;
import org.junit.Test;

public class UseCase19TrainConsistigentTest {

    @Test
    public void testSearch_BogieFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistigent.binarySearch(ids, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(UseCase19TrainConsistigent.binarySearch(ids, "BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistigent.binarySearch(ids, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistigent.binarySearch(ids, "BG550"));
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] ids = {"BG101"};
        assertTrue(UseCase19TrainConsistigent.binarySearch(ids, "BG101"));
    }

    @Test
    public void testSearch_EmptyArray() {
        String[] ids = {};
        assertFalse(UseCase19TrainConsistigent.binarySearch(ids, "BG101"));
    }

    @Test
    public void testSearch_UnsortedInput() {
        String[] ids = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(UseCase19TrainConsistigent.binarySearch(ids, "BG309"));
    }
}