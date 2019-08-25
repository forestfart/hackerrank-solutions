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

        class InnerMethodCheckModifier { // <<-- no access modifiers are allowed here
            private int intReturn() {
                return 1;
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    public class InnerClassCheckModifier {

        public int IntReturn() {
            return 1;
        }

    }
}
