public class TesteEmpregadoBaseMaisComissao {
    public static void main(String[] args) {
        EmpregadoBaseMaisComissao empregado = new EmpregadoBaseMaisComissao(
                "Ana", "Silva", "123.456.789-00", 10_000.00, 0.10, 800.00);
        System.out.println(empregado);
        System.out.printf("Entradas totais: %.2f%n", empregado.entradas());
        empregado.setSalarioBase(1_000.00);
        empregado.getEmpregadoComissao().setVendasBrutas(12_000.00);
        System.out.printf("Entradas após alteração: %.2f%n", empregado.entradas());
    }
}
