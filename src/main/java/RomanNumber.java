/*
Арифметические операции над римскими числами
 */
public class RomanNumber implements Numbers<String> {
    private int numA;
    private int numB;

    @Override
    public String sum(String a, String b) {
        convertRomanToArabic(a, b);
        int sum = numA + numB;
        return ConverterNumber.convertArabicToRoman(sum);
    }

    @Override
    public String sub(String a, String b) {
        convertRomanToArabic(a, b);
        int sub = numA - numB;
        if (sub < 1) try {
            throw new InvalidValueException();
        } catch (InvalidValueException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return ConverterNumber.convertArabicToRoman(sub);
    }

    @Override
    public String mul(String a, String b) {
        convertRomanToArabic(a, b);
        int mul = numA * numB;
        return ConverterNumber.convertArabicToRoman(mul);
    }

    @Override
    public String div(String a, String b) {
        convertRomanToArabic(a, b);
        int div = numA / numB;
        if (div < 1) try {
            throw new InvalidValueException();
        } catch (InvalidValueException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return ConverterNumber.convertArabicToRoman(div);
    }

    /*
    Конвертация римских чисел в арабские
     */
    private void convertRomanToArabic(String a, String b) {
        try {
            numA = ConverterNumber.convertRomanToArabic(a);
            numB = ConverterNumber.convertRomanToArabic(b);
        } catch (NoRomanNumberException e) {
            e.printStackTrace();
        }
    }

    /*
   Проверка на римские числа.
   True - числа являются римскими
   False - числа не являются римскими
   Проверка на то что числа находятся в диапазоне от 1 до 10 включительно. Генерирует исключение RangeNumberException
   если проверка не пройдена
    */
    public static boolean isRomanNumber(String a, String b) throws RangeNumberException {
        int numA;
        int numB;
        try {
            numA = ConverterNumber.convertRomanToArabic(a);
            numB = ConverterNumber.convertRomanToArabic(b);
        } catch (NoRomanNumberException e) {
            return false;
        }

        if ((numA < 1 || numA > 10) || (numB < 1 || numB > 10)) throw new RangeNumberException();

        return true;
    }
}
