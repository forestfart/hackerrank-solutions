package oracle.ocp.clazz;

public class Whiz {
    static int y = 1;

    public static void main(String[] args) {
        abstract class Cal {
            public abstract int calc(int x);
        }

        Cal c = new Cal() {
            public int calc(int x) {
                return x - y;
            }
        };

        System.out.println(c.calc(2));

        class InnerMethodCheckModifier { // <<-- no access modifiers are allowed here, also cannot be static
            private int intReturn() {
                return 100;
            }
        }

        System.out.println(new InnerClassCheckModifier().intReturn());
        System.out.println(new InnerMethodCheckModifier().intReturn());

    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    public static class InnerClassCheckModifier {

        int intReturn() {
            return 55;
        }


    }
}
