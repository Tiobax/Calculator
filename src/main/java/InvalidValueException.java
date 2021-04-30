public class InvalidValueException extends Exception{
    @Override
    public String toString() {
        return "InvalidValueException (Римские цифры не могут быть меньше 1)";
    }
}
