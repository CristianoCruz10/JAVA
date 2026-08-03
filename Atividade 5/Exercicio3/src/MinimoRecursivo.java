public class MinimoRecursivo {
    public static int minimoRecursive(int[] valores) {
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("A matriz deve possuir ao menos um elemento.");
        }
        return minimoRecursive(valores, 0);
    }

    private static int minimoRecursive(int[] valores, int indice) {
        if (indice == valores.length - 1) return valores[indice];
        return Math.min(valores[indice], minimoRecursive(valores, indice + 1));
    }

    public static void main(String[] args) {
        int[] valores = {18, -4, 22, 0, 7, -1};
        System.out.println("Menor valor: " + minimoRecursive(valores));
    }
}
