public class TesteIntegerHuge {
    public static void main(String[] args) {
        IntegerHuge a = new IntegerHuge();
        IntegerHuge b = new IntegerHuge();

        a.parse("1234567890123456789012345678901234567890");
        b.parse("9876543210987654321098765432109876543210");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a é zero? " + a.isZero());
        System.out.println("a é diferente de b? " + a.isDifferentFrom(b));
        System.out.println("a é maior que b? " + a.isBiggerThan(b));
    }
}
