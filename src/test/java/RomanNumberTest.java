import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumberTest {

    @Test
    void isRomanNumber1() throws RangeNumberException {
        assertTrue(RomanNumber.isRomanNumber("I", "X"));
    }

    @Test
    void isRomanNumber2() throws RangeNumberException {
        assertTrue(RomanNumber.isRomanNumber("VI", "IX"));
    }

    @Test
    void isRomanNumber3() {
        assertThrows(RangeNumberException.class, () -> RomanNumber.isRomanNumber("I", "XII"));
    }

    @Test
    void isRomanNumber4() throws RangeNumberException {
        assertFalse(RomanNumber.isRomanNumber("IVI", "X"));
    }

    @Test
    void isRomanNumber5() throws RangeNumberException {
        assertFalse(RomanNumber.isRomanNumber("Hello", "world"));
    }
}