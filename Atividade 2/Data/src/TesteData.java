public class TesteData {
    public static void main(String[] args) {
        Data data = new Data(7, 18, 2026);
        System.out.print("Data inicial: ");
        data.showDate();

        data.setMes(8);
        data.setDia(20);
        data.setAno(2027);

        System.out.print("Data alterada: ");
        data.showDate();
    }
}
