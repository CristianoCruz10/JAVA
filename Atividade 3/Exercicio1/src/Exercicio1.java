import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanho;

        while (true) {
            System.out.print("Digite o tamanho do lado do quadrado (1 a 20): ");

            if (scanner.hasNextInt()) {
                tamanho = scanner.nextInt();
                if (tamanho >= 1 && tamanho <= 20) {
                    break;
                }
                System.out.println("Erro: informe um valor entre 1 e 20.");
            } else {
                System.out.println("Erro: informe um número inteiro.");
                scanner.next();
            }
        }

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (i == 0 || i == tamanho - 1 || j == 0 || j == tamanho - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
