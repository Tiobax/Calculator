public class NoRomanNumberException extends Exception {
    @Override
    public String toString() {
        return "NoRomanNumberException (строка не является римским числом)";
    }
}
