import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class LucasGenerator {

    public static final int FROM = 1;
    public static final int TO = 100;
    public static final String FILE_NAME = "fibseq100.txt";

    public static void main(String[] args) {
        System.out.println("Generowanie ciągu Lucasa");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = FROM; i <= TO; i++) {
                BigDecimal lucasNumber = generateLucasNumber(i);
                writer.write(lucasNumber.toString());
                writer.newLine();
            }
            System.out.println("Wynik zapisany do pliku: " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania do pliku: " + e.getMessage());
        }
    }

    public static BigDecimal generateLucasNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (n == 1) {
            return BigDecimal.valueOf(2);
        }
        if (n == 2) {
            return BigDecimal.ONE;
        }

        BigDecimal a = BigDecimal.valueOf(2);
        BigDecimal b = BigDecimal.ONE;
        BigDecimal result = BigDecimal.ZERO;

        for (int i = 3; i <= n; i++) {
            result = a.add(b);
            a = b;
            b = result;
        }

        return result;
    }
}
