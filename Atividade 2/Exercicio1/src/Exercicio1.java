import java.util.Scanner;

public class Exercicio1 {
    public static int inverterDigitos(int numero) {
        int valor = Math.abs(numero);
        int invertido = 0;

        while (valor > 0) {
            invertido = invertido * 10 + valor % 10;
            valor /= 10;
        }

        return numero < 0 ? -invertido : invertido;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        System.out.println("Número invertido: " + inverterDigitos(numero));
        scanner.close();
    }
}
