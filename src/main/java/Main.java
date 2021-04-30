import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("Введите выражение: " );
            System.out.println("= " + new Calculator().calculate(reader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
