public class Trapezio extends Quadrilatero {
    public Trapezio(Ponto ponto1, Ponto ponto2, Ponto ponto3, Ponto ponto4) {
        super(ponto1, ponto2, ponto3, ponto4);
    }
    public double area() { return areaPeloPoligono(); }
    @Override public String toString() { return "Trapézio"; }
}
