import java.util.Scanner;

/** Lê cinco valores entre 10 e 100 e mantém apenas os valores distintos. */
public class EliminacaoDuplicatas {
    private static final int TOTAL_ENTRADAS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] exclusivos = new int[TOTAL_ENTRADAS]; // menor capacidade necessária no pior caso
        int quantidadeExclusivos = 0;

        System.out.println("Digite cinco números inteiros entre 10 e 100.");
        for (int entrada = 1; entrada <= TOTAL_ENTRADAS; entrada++) {
            int numero = lerNumeroNoIntervalo(scanner, entrada);
            boolean duplicado = false;

            for (int indice = 0; indice < quantidadeExclusivos; indice++) {
                if (exclusivos[indice] == numero) {
                    duplicado = true;
                    break;
                }
            }

            if (duplicado) {
                System.out.println(numero + " já foi informado; valor ignorado.");
            } else {
                exclusivos[quantidadeExclusivos++] = numero;
                System.out.println("Novo valor exclusivo: " + numero);
            }

            System.out.print("Valores exclusivos até agora: ");
            for (int indice = 0; indice < quantidadeExclusivos; indice++) {
                System.out.print(exclusivos[indice] + (indice < quantidadeExclusivos - 1 ? ", " : ""));
            }
            System.out.println();
        }
        scanner.close();
    }

    private static int lerNumeroNoIntervalo(Scanner scanner, int entrada) {
        while (true) {
            System.out.print("Número " + entrada + ": ");
            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                if (numero >= 10 && numero <= 100) {
                    return numero;
                }
            } else {
                scanner.next();
            }
            System.out.println("Entrada inválida. Use um inteiro de 10 a 100.");
        }
    }
}
