public class StringInverse {
    public static void stringInverse(char[] texto) {
        stringInverse(texto, texto.length - 1);
        System.out.println();
    }

    private static void stringInverse(char[] texto, int indice) {
        if (indice < 0) return;
        System.out.print(texto[indice]);
        stringInverse(texto, indice - 1);
    }

    public static void main(String[] args) {
        char[] texto = "Programacao Java".toCharArray();
        System.out.print("Texto invertido: ");
        stringInverse(texto);
    }
}
