public class Racional {
    private int numerador;
    private int denominador;

    public Racional() {
        this(0, 1);
    }

    public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("Denominador não pode ser zero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        reduzir();
    }

    private void reduzir() {
        int divisor = mdc(Math.abs(numerador), Math.abs(denominador));
        numerador /= divisor;
        denominador /= divisor;

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    private int mdc(int a, int b) {
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    public static Racional adicionar(Racional a, Racional b) {
        return new Racional(a.numerador * b.denominador + b.numerador * a.denominador,
                a.denominador * b.denominador);
    }

    public static Racional subtrair(Racional a, Racional b) {
        return new Racional(a.numerador * b.denominador - b.numerador * a.denominador,
                a.denominador * b.denominador);
    }

    public static Racional multiplicar(Racional a, Racional b) {
        return new Racional(a.numerador * b.numerador, a.denominador * b.denominador);
    }

    public static Racional dividir(Racional a, Racional b) {
        return new Racional(a.numerador * b.denominador, a.denominador * b.numerador);
    }

    public String toStringFormat() {
        return numerador + "/" + denominador;
    }

    public String toStringPontoFlutuante(int precisao) {
        return String.format("%1$." + precisao + "f", (double) numerador / denominador);
    }
}
