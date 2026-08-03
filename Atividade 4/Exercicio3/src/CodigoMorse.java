import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/** Codifica texto em Morse e decodifica Morse separado por espaços. */
public class CodigoMorse {
    private static final String[] SIMBOLOS = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ",", ":", ";", "?", "!"
    };
    private static final String[] CODIGOS = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-.-.-", "--..--", "---...", "-.-.-.", "..--..", "-.-.--"
    };
    private static final Map<Character, String> PARA_MORSE = new HashMap<>();
    private static final Map<String, Character> PARA_TEXTO = new HashMap<>();

    static {
        for (int i = 0; i < SIMBOLOS.length; i++) {
            PARA_MORSE.put(SIMBOLOS[i].charAt(0), CODIGOS[i]);
            PARA_TEXTO.put(CODIGOS[i], SIMBOLOS[i].charAt(0));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite 1 para codificar ou 2 para decodificar: ");
        String opcao = scanner.nextLine().trim();
        System.out.print("Digite a frase: ");
        String frase = scanner.nextLine();

        if (opcao.equals("1")) {
            System.out.println("Morse: " + codificar(frase));
        } else if (opcao.equals("2")) {
            System.out.println("Texto: " + decodificar(frase));
        } else {
            System.out.println("Opção inválida.");
        }
        scanner.close();
    }

    public static String codificar(String texto) {
        String textoSemAcentos = Normalizer.normalize(texto.toUpperCase(Locale.ROOT), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        StringBuilder resultado = new StringBuilder();
        String[] palavras = textoSemAcentos.trim().split("\\s+");
        for (int palavra = 0; palavra < palavras.length; palavra++) {
            if (palavra > 0) resultado.append("   ");
            for (int i = 0; i < palavras[palavra].length(); i++) {
                if (i > 0) resultado.append(' ');
                char caractere = palavras[palavra].charAt(i);
                resultado.append(PARA_MORSE.getOrDefault(caractere, "[?]"));
            }
        }
        return resultado.toString();
    }

    public static String decodificar(String morse) {
        StringBuilder resultado = new StringBuilder();
        String[] palavras = morse.trim().split("\\s{3,}");
        for (int palavra = 0; palavra < palavras.length; palavra++) {
            if (palavra > 0) resultado.append(' ');
            for (String codigo : palavras[palavra].trim().split("\\s+")) {
                resultado.append(PARA_TEXTO.getOrDefault(codigo, '?'));
            }
        }
        return resultado.toString();
    }
}
