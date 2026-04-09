import static org.junit.Assert.*;
import org.junit.Test;

public class UseCase18TrainConsistigantTest {

    @Test
    public void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase18TrainConsistigant.searchBogie(bogieIds, "BG309");
        assertTrue(result);
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase18TrainConsistigant.searchBogie(bogieIds, "BG999");
        assertFalse(result);
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase18TrainConsistigant.searchBogie(bogieIds, "BG101");
        assertTrue(result);
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase18TrainConsistigant.searchBogie(bogieIds, "BG550");
        assertTrue(result);
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        boolean result = UseCase18TrainConsistigant.searchBogie(bogieIds, "BG101");
        assertTrue(result);
    }
}