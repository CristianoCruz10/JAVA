public class TesteQuadrilateros {
    public static void main(String[] args) {
        Trapezio trapezio = new Trapezio(new Ponto(0, 0), new Ponto(6, 0), new Ponto(4, 3), new Ponto(1, 3));
        Paralelogramo paralelogramo = new Paralelogramo(new Ponto(0, 0), new Ponto(5, 0), new Ponto(7, 3), new Ponto(2, 3));
        Retangulo retangulo = new Retangulo(new Ponto(0, 0), new Ponto(6, 0), new Ponto(6, 4), new Ponto(0, 4));
        Quadrado quadrado = new Quadrado(new Ponto(0, 0), new Ponto(4, 0), new Ponto(4, 4), new Ponto(0, 4));

        exibirArea(trapezio);
        exibirArea(paralelogramo);
        exibirArea(retangulo);
        exibirArea(quadrado);
    }

    private static void exibirArea(Trapezio figura) {
        System.out.printf("%s: área = %.2f%n", figura, figura.area());
    }
}
