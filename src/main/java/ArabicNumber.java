/*
Арифметические операции над арабскими числами
 */

public class ArabicNumber implements Numbers<Integer> {
    @Override
    public Integer sum(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    @Override
    public Integer sub(String a, String b) {
        return Integer.parseInt(a) - Integer.parseInt(b);
    }

    @Override
    public Integer mul(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    @Override
    public Integer div(String a, String b) {
        return Integer.parseInt(a) / Integer.parseInt(b);
    }

    /*
    Проверка на арабские числа.
    True - числа являются арабскими
    False - числа не являются арабскими
    Проверка на то что числа находятся в диапазоне от 1 до 10 включительно. Генерирует исключение RangeNumberException
    если проверка не пройдена
     */
    public static boolean isArabicNumber(String a, String b) throws RangeNumberException {
        int numA;
        int numB;

        try {
            numA = Integer.parseInt(a);
            numB = Integer.parseInt(b);
        } catch (NumberFormatException ex) {
            return false;
        }

        if ((numA < 1 || numA > 10) || (numB < 1 || numB > 10)) throw new RangeNumberException();

        return true;
    }
}
