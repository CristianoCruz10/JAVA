public class TesteRacional {
    public static void main(String[] args) {
        Racional a = new Racional(2, 4);
        Racional b = new Racional(1, 3);

        System.out.println("a = " + a.toStringFormat());
        System.out.println("b = " + b.toStringFormat());
        System.out.println("Soma = " + Racional.adicionar(a, b).toStringFormat());
        System.out.println("Subtração = " + Racional.subtrair(a, b).toStringFormat());
        System.out.println("Multiplicação = " + Racional.multiplicar(a, b).toStringFormat());
        System.out.println("Divisão = " + Racional.dividir(a, b).toStringFormat());
        System.out.println("Ponto flutuante = " + Racional.adicionar(a, b).toStringPontoFlutuante(4));
    }
}
