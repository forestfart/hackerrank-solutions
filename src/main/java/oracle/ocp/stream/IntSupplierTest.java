package oracle.ocp.stream;

import java.util.function.IntSupplier;

public class IntSupplierTest {

    public static void main(String[] args) {
        IntSupplier ins = IntSupplierTest::getRandomInt10;
        System.out.println(ins.getAsInt());
    }

    private static int getRandomInt10() {
        return (int)(Math.random()*10)+1;
    }

}
