public class EmpregadoTest {
    public static void main(String[] args) {
        Empregado e1 = new Empregado("Ana", "Silva", 2500.00);
        Empregado e2 = new Empregado("Carlos", "Souza", -1000.00);

        System.out.println("Salário anual de " + e1.getPrimeiroNome() + " " + e1.getSobrenome() + ": " + e1.calcularSalarioAnual());
        System.out.println("Salário anual de " + e2.getPrimeiroNome() + " " + e2.getSobrenome() + ": " + e2.calcularSalarioAnual());

        e1.setSalarioMensal(e1.getSalarioMensal() * 1.10);
        e2.setSalarioMensal(e2.getSalarioMensal() * 1.10);

        System.out.println("Novo salário anual de " + e1.getPrimeiroNome() + " " + e1.getSobrenome() + ": " + e1.calcularSalarioAnual());
        System.out.println("Novo salário anual de " + e2.getPrimeiroNome() + " " + e2.getSobrenome() + ": " + e2.calcularSalarioAnual());
    }
}
