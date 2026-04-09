import static org.junit.Assert.*;
import org.junit.Test;

public class UseCase20TrainConsistgantTest {

    @Test(expected = IllegalStateException.class)
    public void testException_WhenEmptyData() {
        String[] ids = {};
        UseCase20TrainConsistgant.searchBogie(ids, "BG101");
    }

    @Test
    public void testSearch_WhenDataExists_Found() {
        String[] ids = {"BG101", "BG205", "BG309"};
        boolean result = UseCase20TrainConsistgant.searchBogie(ids, "BG309");
        assertTrue(result);
    }

    @Test
    public void testSearch_WhenDataExists_NotFound() {
        String[] ids = {"BG101", "BG205", "BG309"};
        boolean result = UseCase20TrainConsistgant.searchBogie(ids, "BG999");
        assertFalse(result);
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertTrue(UseCase20TrainConsistgant.searchBogie(ids, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertTrue(UseCase20TrainConsistgant.searchBogie(ids, "BG309"));
    }
}