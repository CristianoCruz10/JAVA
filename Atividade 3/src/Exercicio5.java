public class Exercicio5 {
    public static void main(String[] args) {
        System.out.println("Fatoriais de 1 a 20:");
        System.out.println("-----------------------------");

        for (int n = 1; n <= 20; n++) {
            long resultado = 1;
            for (int i = 2; i <= n; i++) {
                resultado *= i;
            }
            System.out.printf("%2d! = %20d%n", n, resultado);
        }

        System.out.println("-----------------------------");
        System.out.println("O fatorial de 100 não cabe em long, pois cresce rapidamente.");
    }
}
