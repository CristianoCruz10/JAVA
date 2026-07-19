import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número inteiro: ");
        int numero1 = scanner.nextInt();

        System.out.print("Digite o segundo número inteiro: ");
        int numero2 = scanner.nextInt();

        if (numero1 > numero2) {
            System.out.println(numero1 + " é maior");
        } else if (numero2 > numero1) {
            System.out.println(numero2 + " é maior");
        } else {
            System.out.println("Esses números são iguais");
        }

        scanner.close();
    }
}
