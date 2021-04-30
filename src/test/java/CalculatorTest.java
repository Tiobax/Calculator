import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test1() {
        Calculator calculator = new Calculator();
        assertThrows(IncorrectInputDataException.class, () -> calculator.calculate("4 - IX"));
    }

    @Test
    void test2() {
        Calculator calculator = new Calculator();
        assertThrows(RangeNumberException.class, () -> calculator.calculate("4 * 32"));
    }

    @Test
    void test3() {
        Calculator calculator = new Calculator();
        assertThrows(RangeNumberException.class, () -> calculator.calculate("III / XI"));
    }

    @Test
    void test4() {
        Calculator calculator = new Calculator();
        assertThrows(IncorrectArithmeticOperationException.class, () -> calculator.calculate("III % V"));
    }

    @Test
    void test5() {
        Calculator calculator = new Calculator();
        assertThrows(IncorrectInputDataException.class, () -> calculator.calculate("III * V k"));
    }

    @Test
    void test6() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals("IX", calculator.calculate("IV + V"));
    }

    @Test
    void test7() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals("XXXVI", calculator.calculate("IV * IX"));
    }

    @Test
    void test9() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals("II", calculator.calculate("VII / III"));
    }

    @Test
    void test11() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(9, calculator.calculate("4 + 5"));
    }

    @Test
    void test12() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(36, calculator.calculate("4 * 9"));
    }

    @Test
    void test13() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(-8, calculator.calculate("1 - 9"));
    }

    @Test
    void test14() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.calculate("7 / 3"));
    }

    @Test
    void test15() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.calculate("3 / 7"));
    }

}