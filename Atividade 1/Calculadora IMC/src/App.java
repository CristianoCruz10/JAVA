import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Digite o peso em quilogramas: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite a altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = peso / (altura * altura);

        System.out.printf("Seu IMC é: %.2f%n", imc);
        System.out.println("\nCategorias de IMC (NIH):");
        System.out.println("Abaixo do peso: menor que 18.5");
        System.out.println("Peso normal: 18.5 até 24.9");
        System.out.println("Sobrepeso: 25.0 até 29.9");
        System.out.println("Obesidade grau I: 30.0 até 34.9");
        System.out.println("Obesidade grau II: 35.0 até 39.9");
        System.out.println("Obesidade grau III: 40.0 ou mais");

        scanner.close();
    }
}
