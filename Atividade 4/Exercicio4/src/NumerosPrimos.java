import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Verifica se um inteiro é primo e exibe seus fatores primos sem repetição. */
public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um inteiro maior que 1: ");
        while (!scanner.hasNextLong()) {
            scanner.next();
            System.out.print("Entrada inválida. Digite um inteiro maior que 1: ");
        }
        long numero = scanner.nextLong();
        if (numero <= 1) {
            System.out.println("O número deve ser maior que 1.");
        } else if (ehPrimo(numero)) {
            System.out.println(numero + " é primo. Seus únicos fatores são 1 e " + numero + ".");
        } else {
            System.out.println(numero + " não é primo.");
            System.out.println("Fatores primos exclusivos: " + fatoresPrimosExclusivos(numero));
        }
        scanner.close();
    }

    private static boolean ehPrimo(long numero) {
        if (numero < 2) return false;
        for (long divisor = 2; divisor <= numero / divisor; divisor++) {
            if (numero % divisor == 0) return false;
        }
        return true;
    }

    private static List<Long> fatoresPrimosExclusivos(long numero) {
        List<Long> fatores = new ArrayList<>();
        for (long divisor = 2; divisor <= numero / divisor; divisor++) {
            if (numero % divisor == 0) {
                fatores.add(divisor);
                while (numero % divisor == 0) numero /= divisor;
            }
        }
        if (numero > 1) fatores.add(numero);
        return fatores;
    }
}
