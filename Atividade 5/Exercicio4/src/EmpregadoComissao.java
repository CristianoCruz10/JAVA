public class EmpregadoComissao {
    private final String primeiroNome;
    private final String sobrenome;
    private final String cpf;
    private double vendasBrutas;
    private double porcentagemComissao;

    public EmpregadoComissao(String primeiroNome, String sobrenome, String cpf,
            double vendasBrutas, double porcentagemComissao) {
        if (vendasBrutas < 0 || porcentagemComissao <= 0) throw new IllegalArgumentException("Valores de venda ou comissão inválidos.");
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.vendasBrutas = vendasBrutas;
        this.porcentagemComissao = porcentagemComissao;
    }

    public double entradas() { return vendasBrutas * porcentagemComissao; }
    public String getPrimeiroNome() { return primeiroNome; }
    public String getSobrenome() { return sobrenome; }
    public String getCpf() { return cpf; }
    public double getVendasBrutas() { return vendasBrutas; }
    public double getPorcentagemComissao() { return porcentagemComissao; }
    public void setVendasBrutas(double valor) { if (valor < 0) throw new IllegalArgumentException("Vendas devem ser >= 0."); vendasBrutas = valor; }
    public void setPorcentagemComissao(double valor) { if (valor <= 0) throw new IllegalArgumentException("Comissão deve ser > 0."); porcentagemComissao = valor; }

    @Override public String toString() {
        return String.format("empregado comissao: %s %s%ncpf: %s%nvendas brutas: %.2f%ncomissao: %.2f",
                primeiroNome, sobrenome, cpf, vendasBrutas, porcentagemComissao);
    }
}
