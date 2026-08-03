/** Os quatro pontos devem ser informados em ordem ao redor da figura. */
public class Quadrilatero {
    private final Ponto ponto1;
    private final Ponto ponto2;
    private final Ponto ponto3;
    private final Ponto ponto4;

    public Quadrilatero(Ponto ponto1, Ponto ponto2, Ponto ponto3, Ponto ponto4) {
        this.ponto1 = ponto1;
        this.ponto2 = ponto2;
        this.ponto3 = ponto3;
        this.ponto4 = ponto4;
    }

    protected Ponto[] getPontos() { return new Ponto[] {ponto1, ponto2, ponto3, ponto4}; }

    protected double areaPeloPoligono() {
        Ponto[] p = getPontos();
        double soma = 0;
        for (int i = 0; i < p.length; i++) {
            Ponto proximo = p[(i + 1) % p.length];
            soma += p[i].getX() * proximo.getY() - p[i].getY() * proximo.getX();
        }
        return Math.abs(soma) / 2;
    }

    @Override public String toString() { return "Quadrilátero"; }
}
