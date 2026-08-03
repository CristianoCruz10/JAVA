import java.util.Scanner;

/** Ordena uma lista de inteiros pelo método bubble sort. */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidade = lerQuantidade(scanner);
        int[] numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Digite um inteiro: ");
            }
            numeros[i] = scanner.nextInt();
        }

        System.out.print("Antes: ");
        exibir(numeros);
        ordenar(numeros);
        System.out.print("Depois: ");
        exibir(numeros);
        scanner.close();
    }

    /**
     * A cada passagem, o maior elemento ainda não ordenado vai para o fim.
     * No pior caso há (n - 1) + (n - 2) + ... + 1 comparações, isto é,
     * n(n - 1)/2. Logo, a ordem de crescimento é O(n²).
     */
    public static void ordenar(int[] valores) {
        for (int fim = valores.length - 1; fim > 0; fim--) {
            boolean houveTroca = false;
            for (int indice = 0; indice < fim; indice++) {
                if (valores[indice] > valores[indice + 1]) {
                    int temporario = valores[indice];
                    valores[indice] = valores[indice + 1];
                    valores[indice + 1] = temporario;
                    houveTroca = true;
                }
            }
            if (!houveTroca) break;
        }
    }

    private static int lerQuantidade(Scanner scanner) {
        while (true) {
            System.out.print("Quantos números deseja ordenar? ");
            if (scanner.hasNextInt()) {
                int quantidade = scanner.nextInt();
                if (quantidade > 0) return quantidade;
            } else {
                scanner.next();
            }
            System.out.println("Digite uma quantidade inteira positiva.");
        }
    }

    private static void exibir(int[] valores) {
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + (i < valores.length - 1 ? ", " : "\n"));
        }
    }
}
