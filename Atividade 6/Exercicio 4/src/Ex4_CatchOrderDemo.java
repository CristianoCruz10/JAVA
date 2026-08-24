public class Ex4_CatchOrderDemo {
    static class MyException extends Exception {}
    static class MySubException extends MyException {}

    public static void main(String[] args) {
        try {
            MyException exception = new MySubException();
            throw exception;
        } catch (MySubException e) {
            System.out.println("Capturado MySubException");
        } catch (MyException e) {
            System.out.println("Capturado MyException (superclasse)");
        }
    }
}
