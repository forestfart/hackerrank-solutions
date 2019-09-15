package oracle.ocp.stream;

import java.util.function.IntBinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        IntBinaryOperator inp = (i1, i2) -> i1 / i2;
        System.out.println(inp.applyAsInt(53, 5));
    }
}

class BinOperator2 {
    public static void main(String[] args) {
        IntBinaryOperator ibo = Integer::compare;
        System.out.println(ibo.applyAsInt(10,12));
    }

}

