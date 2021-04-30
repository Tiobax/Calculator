/*
Класс ковертер из арабских в римские и обратно
 */
import java.util.HashMap;

public class ConverterNumber {
    public static HashMap<Character, Integer> romanNumbers = new HashMap<>();
    public static HashMap<Integer, String> arabicNumbers = new HashMap<>();
    static {
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        arabicNumbers.put(1, "I");
        arabicNumbers.put(5, "V");
        arabicNumbers.put(10, "X");
        arabicNumbers.put(50, "L");
        arabicNumbers.put(100, "C");
    }

    /*
    Конвертирует входящую строку в арабское число
    Если входящая строка не является римским числом, генерирует исключение NoRomanNumberException
     */
    public static int convertRomanToArabic(String str) throws NoRomanNumberException {
        int result = 0;
        int prevNumber = 0;
        char[] reversStr = new StringBuilder(str).reverse().toString().toCharArray();
        for (int i = 0; i < reversStr.length; i++) {
            int currentNumber;
            try {
                currentNumber = romanNumbers.get(reversStr[i]);
            } catch (NullPointerException e) {
                throw new NoRomanNumberException();
            }

            if (currentNumber >= prevNumber) {
                result += currentNumber;
                prevNumber = currentNumber;
            } else {
                result -= currentNumber;
            }
        }
        String controlStr = ConverterNumber.convertArabicToRoman(result);
        if (controlStr.equals(str)) return result;
        else throw new NoRomanNumberException();
    }

    /*
    Конвертирует входящее арабское число в римское
    Если входящее арабское число не входит в диапозон от 1 до 399 включительно, генерирует исключение ConvertationArabicToRomanException
     */
    public static String convertArabicToRoman(Integer number) {
        int tmpNumber = number;
        StringBuilder romanNumber = new StringBuilder();
        int num = 10;
        if (number > 0 && number < 400) {
            while (tmpNumber != 0) {
                int remain = tmpNumber % num;
                if (remain != 0) {
                    if (remain == (int)(0.4 * num)) {
                        romanNumber.insert(0, arabicNumbers.get((int) (0.1 * num)) + arabicNumbers.get((int) (0.5 * num)));
                    } else if (remain == (int)(0.9 * num)) {
                        romanNumber.insert(0, arabicNumbers.get((int) (0.1 * num)) + arabicNumbers.get(num));
                    } else if ((int)(remain / (0.5 * num)) == 0) {
                        for (int i = 0; i < (int)(remain / (0.1 * num)); i++) {
                            romanNumber.insert(0, arabicNumbers.get((int) (0.1 * num)));
                        }
                    } else {
                        for (int i = 0; i < (int)((remain - (0.5 * num)) / (0.1 * num)); i++) {
                            romanNumber.insert(0, "" + arabicNumbers.get((int) (0.1 * num)));
                        }
                        romanNumber.insert(0, "" + arabicNumbers.get((int) (0.5 * num)));
                    }
                }
                tmpNumber -= remain;
                num *= 10;
            }
        } else try {
            throw new ConvertationArabicToRomanException();
        } catch (ConvertationArabicToRomanException e) {
            e.printStackTrace();
        }
        return romanNumber.toString();
    }
}
