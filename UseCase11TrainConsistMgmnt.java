import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class UseCase11TrainConsistMgmntTest {

    // Regex patterns (same as main class)
    private final String trainIdRegex = "^TRN-\\d{4}$";
    private final String cargoCodeRegex = "^[A-Z]{3}-[A-Z]{2}$";

    // Helper methods
    private boolean isValidTrainId(String input) {
        return Pattern.matches(trainIdRegex, input);
    }

    private boolean isValidCargoCode(String input) {
        return Pattern.matches(cargoCodeRegex, input);
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainId("TRAIN-1234")); // wrong prefix
        assertFalse(isValidTrainId("TRN1234"));    // missing hyphen
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PE-AB"));     // less letters
        assertFalse(isValidCargoCode("PETAB"));     // missing hyphen
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainId("TRN-123"));   // 3 digits
        assertFalse(isValidTrainId("TRN-12345")); // 5 digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("pet-ab")); // lowercase
        assertFalse(isValidCargoCode("Pet-Ab")); // mixed case
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainId(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainId(" TRN-1234")); // leading space
        assertFalse(isValidTrainId("TRN-1234 ")); // trailing space
        assertFalse(isValidCargoCode(" PET-AB"));
        assertFalse(isValidCargoCode("PET-AB "));
    }
}