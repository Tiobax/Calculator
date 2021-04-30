public class ConvertationArabicToRomanException extends Exception{
    @Override
    public String toString() {
        return "ConvertationArabicToRomanException (конвертировать можно только числа от 1 до 399 включительно)";
    }
}
