import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private List<String> list = new ArrayList();
    private final List<String> arithmeticOperation = Arrays.asList(new String[]{"+", "-", "*", "/"});

    /*
    Проверки на корректность входящей строки
    Определение типа чисел
    Запуск вычисления
     */
    public Object calculate(String str) throws Exception {
        list = Arrays.stream(str.split(" ")).toList();
        if (list.size() != 3) throw new IncorrectInputDataException();
        if (!arithmeticOperation.contains(list.get(1))) throw new IncorrectArithmeticOperationException();
        if (ArabicNumber.isArabicNumber(list.get(0), list.get(2))) {
            Numbers<Integer> arabicNumber = new ArabicNumber();
            return getResult(arabicNumber);
        }
        if (RomanNumber.isRomanNumber(list.get(0), list.get(2))) {
            Numbers<String> romanNumber = new RomanNumber();
            return getResult(romanNumber);
        }
        throw new IncorrectInputDataException();
    }

    /*
    Вызов арифметических операций для определенного типа чисел
    */
    private <T> T getResult(Numbers<T> number) {
        if ("+".equals(list.get(1))) {
            return number.sum(list.get(0), list.get(2));
        } else if ("/".equals(list.get(1))) {
            return number.div(list.get(0), list.get(2));
        } else if ("*".equals(list.get(1))) {
            return number.mul(list.get(0), list.get(2));
        } else if ("-".equals(list.get(1))) {
            return number.sub(list.get(0), list.get(2));
        }
        return null;
    }


}
