package oracle.ocp.io;

import java.io.Closeable;

public class TryWithResourcesTest {

    public static void main(String[] args) {
        try (Closeable1 closeable1 = new Closeable1();
             CloseableTest closeableTest = new CloseableTest()) {
            System.out.println("Here we go...");
            closeable1.print();
            closeableTest.print();
            throw new Exception();
        } catch (Exception e) {
            System.err.println("Exception goes shouting");
        } finally {
            System.out.println("Finally now goes..");
        }
        Closeable1 closeable1 = new Closeable1();
        try {
            closeable1.close();
            closeable1.print();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class Closeable1 implements AutoCloseable {
    void print() throws Exception {
        System.out.println("AutoCloseable prints");
        throw new Exception();
    }

    @Override
    public void close() throws Exception {
        System.out.println("AutoCloseable closed.");
    }
}

class CloseableTest implements Closeable {
    void print() {
        System.out.println("Closeable prints");
    }

    @Override
    public void close() {
        System.out.println("Closeable closed.");
    }
}

class CloseableTest2 {
    public void close() {
        System.out.println("No, it does not work!");
    }
}

