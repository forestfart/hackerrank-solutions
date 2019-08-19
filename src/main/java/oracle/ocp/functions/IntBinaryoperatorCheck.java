package oracle.ocp.functions;

import java.util.function.IntBinaryOperator;

public class IntBinaryoperatorCheck {
    public static void main(String[] args) {
        IntBinaryOperator ibo = Integer::compare;

        int x = ibo.applyAsInt(12,11);
        System.out.println(x);
    }

}
