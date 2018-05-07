package others;

import java.io.IOException;

class SomeClass {
    public synchronized void doSomething() {
        synchronized (SomeClass.class) {
            System.out.println("Sdfsdf");
        }
    }
}


public class TestQuestions {

    public static void mthod(Object o) {
        System.out.println("  sdf  ");
    }

    public static void mthod(String s) {
        System.out.println("  sdfsdfsdf  ");
    }

/*    private static void doriskyOperatioons() {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException iae) {
            System.out.println("Illeg cought");
            try {
                throw new IllegalArgumentException();
            } catch (RuntimeException re) {
                System.out.println("in exceprt");
            } finally {
                System.out.println("in nested finally");
            }
        } finally {
            System.out.println("in finally");
        }

    }*/


    public static void main(String[] args) throws IOException {

        String name = "Hello World!";
        name = (name =="Hello World!") ? name.replace("Hello", "Hi") : name;

        name = name.startsWith("Hello") ? name.replace("World", "Sabre") : name;

        System.out.println(name);

        // doriskyOperatioons();

        String test1 = "test";
        String test2 = "test";
        String test3 = new String("test");

        System.out.println((test1==test2) == test1.equals(test2));
        System.out.println((test1==test3) == test2.equals(test3));
        System.out.println((test1==test2) == test1.equals(test3));

/*        try {
            System.exit(0);
        } finally {
            System.out.println("Finally");
        }*/

    }
}
