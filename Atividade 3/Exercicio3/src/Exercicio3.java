import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um número binário (apenas 0 e 1): ");
            String entrada = scanner.nextLine().trim();

            if (entrada.matches("[01]+")) {
                int decimal = 0;

                for (int i = 0; i < entrada.length(); i++) {
                    decimal = decimal * 2 + (entrada.charAt(i) == '1' ? 1 : 0);
                }

                System.out.println("O valor decimal é: " + decimal);
                break;
            }

            System.out.println("Erro: use apenas os dígitos 0 e 1.");
        }

        scanner.close();
    }
}
