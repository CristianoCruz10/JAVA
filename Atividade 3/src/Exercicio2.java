import java.util.Scanner;

public class Exercicio2 {
    public static boolean isPalindrome(String texto) {
        String invertido = new StringBuilder(texto).reverse().toString();
        return texto.equals(invertido);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um número inteiro de cinco dígitos: ");
            String entrada = scanner.nextLine().trim();

            if (entrada.matches("\\d+") && entrada.length() == 5) {
                if (isPalindrome(entrada)) {
                    System.out.println("O número " + entrada + " é um palíndromo.");
                } else {
                    System.out.println("O número " + entrada + " não é um palíndromo.");
                }
                break;
            }

            System.out.println("Erro: informe um número inteiro de cinco dígitos.");
        }

        scanner.close();
    }
}
