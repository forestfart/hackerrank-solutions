package oracle.ocp.exceptions;

public class ItWillNotDoTheStuff {
    public static void main(String[] args) {
        try {
            doStuff(null);
        } catch (NullPointerException npe) {
            System.out.print(" Caught ");
        }
    }

    private static void doStuff(Object o) {
        try {
            if (o == null) {
                throw new NullPointerException();
            }
        } finally {
            System.out.print(" Finally ");
        }
        System.out.print(" Do Stuff ");
    }
}
