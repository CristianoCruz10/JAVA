public class Ex1_ExceptionDemo {
    static class ExceptionA extends Exception {
        public ExceptionA(String msg) { super(msg); }
    }

    static class ExceptionB extends ExceptionA {
        public ExceptionB(String msg) { super(msg); }
    }

    static class ExceptionC extends ExceptionB {
        public ExceptionC(String msg) { super(msg); }
    }

    public static void main(String[] args) {
        captureException(new ExceptionB("Exceção do tipo ExceptionB lançada"));
        captureException(new ExceptionC("Exceção do tipo ExceptionC lançada"));
    }

    static void captureException(ExceptionA exception) {
        try {
            throw exception;
        } catch (ExceptionA e) {
            System.out.println("Exceção capturada pelo bloco ExceptionA");
            System.out.println("Mensagem: " + e.getMessage());
        }
    }
}
