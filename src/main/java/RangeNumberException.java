public class RangeNumberException extends Exception {
    @Override
    public String toString() {
        return "RangeNumberException (числа выходят за пределы от 1 до 10 включительно)";
    }
}
