import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número inteiro: ");
        int numero1 = scanner.nextInt();

        System.out.print("Digite o segundo número inteiro: ");
        int numero2 = scanner.nextInt();

        int soma = numero1 + numero2;
        int produto = numero1 * numero2;
        int diferenca = numero1 - numero2;

        if (numero2 == 0) {
            System.out.println("Não é possível dividir por zero.");
        } else {
            double quociente = (double) numero1 / numero2;
            System.out.println("Soma: " + soma);
            System.out.println("Produto: " + produto);
            System.out.println("Diferença: " + diferenca);
            System.out.println("Quociente: " + quociente);
        }

        scanner.close();
    }
}
