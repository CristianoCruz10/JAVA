import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalVendas = 0.0;

        while (true) {
            System.out.print("Digite o número do produto (1-5) ou -1 para encerrar: ");
            int produto = scanner.nextInt();
            scanner.nextLine();

            if (produto == -1) {
                break;
            }

            if (produto < 1 || produto > 5) {
                System.out.println("Erro: produto inválido.");
                continue;
            }

            System.out.print("Digite a quantidade vendida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            if (quantidade < 0) {
                System.out.println("Erro: quantidade inválida.");
                continue;
            }

            double preco = 0.0;
            switch (produto) {
                case 1:
                    preco = 2.98;
                    break;
                case 2:
                    preco = 4.50;
                    break;
                case 3:
                    preco = 9.98;
                    break;
                case 4:
                    preco = 4.49;
                    break;
                case 5:
                    preco = 6.87;
                    break;
            }

            double subtotal = preco * quantidade;
            totalVendas += subtotal;
            System.out.printf("Subtotal do produto %d: R$ %.2f%n", produto, subtotal);
        }

        System.out.printf("Valor total de vendas: R$ %.2f%n", totalVendas);
        scanner.close();
    }
}
