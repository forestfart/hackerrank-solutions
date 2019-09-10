package oracle.ocp.clazz;

public class LocalInnerClassTest {
    private int length = 5;

    private void calculate() {
        final int width = 20;

        class Inner {
            private void multiply() {
                System.out.println(length * width);
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        LocalInnerClassTest outer = new LocalInnerClassTest();
        outer.calculate();
    }
}
