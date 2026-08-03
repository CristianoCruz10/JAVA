/** Usa composição: possui um EmpregadoComissao, sem estender essa classe. */
public class EmpregadoBaseMaisComissao {
    private final EmpregadoComissao empregadoComissao;
    private double salarioBase;

    public EmpregadoBaseMaisComissao(String primeiroNome, String sobrenome, String cpf,
            double vendasBrutas, double porcentagemComissao, double salarioBase) {
        empregadoComissao = new EmpregadoComissao(primeiroNome, sobrenome, cpf, vendasBrutas, porcentagemComissao);
        setSalarioBase(salarioBase);
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0) throw new IllegalArgumentException("O salário base deve ser >= 0.");
        this.salarioBase = salarioBase;
    }
    public double getSalarioBase() { return salarioBase; }
    public double entradas() { return salarioBase + empregadoComissao.entradas(); }
    public EmpregadoComissao getEmpregadoComissao() { return empregadoComissao; }

    @Override public String toString() {
        return String.format("empregado base mais comissao:%n%s%nsalario base: %.2f", empregadoComissao, salarioBase);
    }
}
