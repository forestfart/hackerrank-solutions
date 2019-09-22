package oracle.ocp.functions;

import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class CurryingTest {

    public static void main(String[] args) {
        BinaryOperator add = (a, b) -> (int)a + (int)b;
        System.out.println("Simple addition: " + add.apply(1,2) );

        IntFunction<IntUnaryOperator> curriedAdd = a -> b -> a + b;
        System.out.println("Curried add: " + curriedAdd.apply(1).applyAsInt(3));
    }
}
