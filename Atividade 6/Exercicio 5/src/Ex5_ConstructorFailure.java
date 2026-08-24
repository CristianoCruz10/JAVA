public class Ex5_ConstructorFailure {
    static class aClass {
        public aClass() throws Exception {
            throw new Exception("Falha no construtor de aClass");
        }
    }

    public static void main(String[] args) {
        try {
            aClass oneClass = new aClass();
            System.out.println("Instanciado: " + oneClass);
        } catch (Exception e) {
            System.out.println("Capturada exceção lançada pelo construtor:");
            e.printStackTrace(System.out);
        }
    }
}
