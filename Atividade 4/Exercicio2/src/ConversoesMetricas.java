import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/** Converte unidades de comprimento, volume e massa por meio de uma unidade-base. */
public class ConversoesMetricas {
    private static final Map<String, Unidade> UNIDADES = criarUnidades();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.println("Conversões disponíveis: comprimento, volume e massa.");
        System.out.println("Exemplos de unidades: metro, centímetro, polegada, litro, quarto, grama, quilograma e libra.");

        double valor = lerValor(scanner);
        System.out.print("Unidade de origem: ");
        Unidade origem = localizar(scanner.nextLine());
        System.out.print("Unidade de destino: ");
        Unidade destino = localizar(scanner.nextLine());

        if (origem == null || destino == null) {
            System.out.println("Conversão inválida: uma das unidades não foi reconhecida.");
        } else if (!origem.grandeza.equals(destino.grandeza)) {
            System.out.println("Conversão inválida: " + origem.grandeza + " não pode ser convertido em " + destino.grandeza + ".");
        } else {
            double resultado = valor * origem.paraBase / destino.paraBase;
            System.out.printf(Locale.US, "%.4f %s equivalem a %.4f %s.%n", valor, origem.nome, resultado, destino.nome);
        }
        scanner.close();
    }

    private static double lerValor(Scanner scanner) {
        while (true) {
            System.out.print("Valor a converter: ");
            if (scanner.hasNextDouble()) {
                double valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;
            }
            scanner.nextLine();
            System.out.println("Informe um número válido.");
        }
    }

    private static Unidade localizar(String texto) {
        return UNIDADES.get(normalizar(texto));
    }

    private static Map<String, Unidade> criarUnidades() {
        Map<String, Unidade> unidades = new HashMap<>();
        adicionar(unidades, "metro", "comprimento", 1, "metros", "m");
        adicionar(unidades, "centimetro", "comprimento", 0.01, "centimetros", "cm");
        adicionar(unidades, "quilometro", "comprimento", 1000, "quilometros", "km");
        adicionar(unidades, "polegada", "comprimento", 0.0254, "polegadas", "in");
        adicionar(unidades, "pe", "comprimento", 0.3048, "pes", "ft");
        adicionar(unidades, "litro", "volume", 1, "litros", "l");
        adicionar(unidades, "mililitro", "volume", 0.001, "mililitros", "ml");
        adicionar(unidades, "quarto", "volume", 0.946352946, "quartos", "qt");
        adicionar(unidades, "galao", "volume", 3.785411784, "galoes", "gal");
        adicionar(unidades, "grama", "massa", 1, "gramas", "g");
        adicionar(unidades, "quilograma", "massa", 1000, "quilogramas", "kg");
        adicionar(unidades, "libra", "massa", 453.59237, "libras", "lb");
        return unidades;
    }

    private static void adicionar(Map<String, Unidade> unidades, String nome, String grandeza, double paraBase, String... sinonimos) {
        Unidade unidade = new Unidade(nome, grandeza, paraBase);
        unidades.put(normalizar(nome), unidade);
        for (String sinonimo : sinonimos) unidades.put(normalizar(sinonimo), unidade);
    }

    private static String normalizar(String texto) {
        return Normalizer.normalize(texto.trim().toLowerCase(Locale.ROOT), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }

    private static class Unidade {
        private final String nome;
        private final String grandeza;
        private final double paraBase;

        Unidade(String nome, String grandeza, double paraBase) {
            this.nome = nome;
            this.grandeza = grandeza;
            this.paraBase = paraBase;
        }
    }
}
