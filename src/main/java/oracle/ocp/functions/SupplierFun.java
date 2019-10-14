package oracle.ocp.functions;

import java.util.function.Supplier;

public class SupplierFun {
    static class Bird {
        public void fly() {
            System.out.print("Can fly");
        }
    }

    static class Penguin extends Bird {
        public void fly() {
            System.out.print("Cannot fly");
        }
    }

    public static void main(String[] args) {
        fly(() -> new SupplierFun.Bird());
        fly(Penguin::new);
        fliesToo(Bird::new);

        try {
            fly(Bird::new);
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void fly(Supplier<Bird> bird) {
        bird.get().fly();
    }

    static void fliesToo(Supplier<? extends Bird> bird) {
        bird.get().fly();
    }
}
