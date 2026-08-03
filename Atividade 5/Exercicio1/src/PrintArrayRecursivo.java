public class PrintArrayRecursivo {
    public static void printArray(int[] valores) {
        printArray(valores, 0);
        System.out.println();
    }

    private static void printArray(int[] valores, int indice) {
        if (indice == valores.length) return;
        System.out.print(valores[indice] + (indice < valores.length - 1 ? " " : ""));
        printArray(valores, indice + 1);
    }

    public static void main(String[] args) {
        int[] valores = {10, 20, 30, 40, 50};
        printArray(valores);
    }
}
