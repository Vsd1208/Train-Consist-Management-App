import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class UseCase14TrainConsistMgmntTest {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String name;
        int capacity;

        PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than 0");
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie b = new PassengerBogie("B1", 70);

        assertEquals(70, b.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("B2", -5);
        });

        assertEquals("Capacity must be greater than 0", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("B3", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("B4", 0);
        });

        assertTrue(ex.getMessage().contains("greater than 0"));
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie b = new PassengerBogie("B5", 80);

        assertEquals("B5", b.name);
        assertEquals(80, b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        List<PassengerBogie> list = new ArrayList<>();

        list.add(new PassengerBogie("B1", 60));
        list.add(new PassengerBogie("B2", 75));
        list.add(new PassengerBogie("B3", 90));

        assertEquals(3, list.size());
    }
}