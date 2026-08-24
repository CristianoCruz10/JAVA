import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Ex2_PhoneWordGenerator {
    private static final String[] MAP = {
        "",
        "",
        "ABC",
        "DEF",
        "GHI",
        "JKL",
        "MNO",
        "PRS",
        "TUV",
        "WXY"
    };

    public static void main(String[] args) {
        String number;

        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite um número de telefone com 7 dígitos: ");
            number = scanner.nextLine().trim();
        } else {
            number = args[0].trim();
        }

        if (number.length() != 7) {
            System.out.println("Forneça exatamente 7 dígitos (evite 0 e 1).");
            return;
        }
        for (char c : number.toCharArray()) {
            if (c < '2' || c > '9') {
                System.out.println("Número inválido: use apenas dígitos de 2 a 9 (evite 0 e 1). Encontrado: " + c);
                return;
            }
        }

        String outName = "words_" + number + ".txt";
        File exerciseDirectory = new File("Atividade 6/Exercicio 2");
        if (!exerciseDirectory.isDirectory()) {
            exerciseDirectory = new File(".");
        }
        File outFile = new File(exerciseDirectory, outName);

        try (Formatter fmt = new Formatter(outFile)) {
            char[] digits = number.toCharArray();
            char[] buffer = new char[7];
            generate(fmt, digits, 0, buffer);
            System.out.println("Arquivo gerado: " + outFile.getPath());
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    private static void generate(Formatter fmt, char[] digits, int pos, char[] buffer) {
        if (pos == digits.length) {
            fmt.format("%s%n", new String(buffer));
            return;
        }
        int d = digits[pos] - '0';
        String letters = MAP[d];
        for (int i = 0; i < letters.length(); i++) {
            buffer[pos] = letters.charAt(i);
            generate(fmt, digits, pos + 1, buffer);
        }
    }
}
