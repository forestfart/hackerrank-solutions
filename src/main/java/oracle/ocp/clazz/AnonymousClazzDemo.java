package oracle.ocp.clazz;

public class AnonymousClazzDemo {

    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    static class Inner {
        public static void main(String args[]) {
            System.out.println("Static inner class main method");
        }
    }

    class Inner2 {
        public void main(String args[]) {
            System.out.println("Main method will never fit here.");
        }
    }

    private int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }

    public static void main(String[] args) {
        int value = new AnonymousClazzDemo().admission(100);

        System.out.println(value);

        A a = new A(); // <<- lol
    }

}

class A {
    protected A(){};
}

