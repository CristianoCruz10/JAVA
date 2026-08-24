public class Ex3_RetriggerException {
    static void unMethod2() throws Exception {
        throw new Exception("Exceção inicial em unMethod2");
    }

    static void unMethod() throws Exception {
        try {
            unMethod2();
        } catch (Exception e) {
            System.out.println("unMethod capturou e vai relançar: " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            unMethod();
        } catch (Exception e) {
            System.out.println("Exceção capturada no main. Stack trace:");
            e.printStackTrace(System.out);
        }
    }
}
