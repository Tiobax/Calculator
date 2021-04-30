import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterNumberTest {
    List<String> listArabicNumber = Arrays.asList("I","II","III","IV","V","VI","VII","VIII","IX","X",
            "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
            "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
            "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
            "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
            "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
            "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
            "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
            "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
            "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C");

    @Test
    void convertRomanToArabic() throws NoRomanNumberException {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            expected.add(i);
            actual.add(ConverterNumber.convertRomanToArabic(listArabicNumber.get(i-1)));
        }
        assertEquals(expected, actual);
    }

    @Test
    void convertRomanToArabic2() {
        assertThrows(NoRomanNumberException.class, () -> ConverterNumber.convertRomanToArabic("XLXII"));
    }

    @Test
    void convertRomanToArabic3() {
        assertThrows(NoRomanNumberException.class, () -> ConverterNumber.convertRomanToArabic("XLXHELLOII"));
    }

    @Test
    void convertArabicToRoman() {
        List<String> actual = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            actual.add(ConverterNumber.convertArabicToRoman(i));
        }
        assertEquals(listArabicNumber, actual);
    }

    @Test
    void convertArabicToRoman1() {
        assertEquals("CCCXCIX", ConverterNumber.convertArabicToRoman(399));
    }

}