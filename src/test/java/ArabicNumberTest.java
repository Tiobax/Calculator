import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArabicNumberTest {

    @Test
    void isArabicNumber1() throws RangeNumberException {
        assertTrue(ArabicNumber.isArabicNumber("1", "5"));
    }

    @Test
    void isArabicNumber2() throws RangeNumberException {
        assertFalse(ArabicNumber.isArabicNumber("1.0", "5"));
    }

    @Test
    void isArabicNumber3() throws RangeNumberException {
        assertFalse(ArabicNumber.isArabicNumber("1", "II"));
    }

    @Test
    void isArabicNumber4() throws RangeNumberException {
        assertTrue(ArabicNumber.isArabicNumber("10", "1"));
    }

    @Test
     void isArabicNumber5() {
        assertThrows(RangeNumberException.class, () -> ArabicNumber.isArabicNumber("1", "11"));
    }

}