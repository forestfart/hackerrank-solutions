package oracle.ocp;

import java.util.function.LongUnaryOperator;

public class FunctionPredicate {
    public static void main(String[] args) {
        LongUnaryOperator luo = l -> l+2;
        long l = luo.compose(luo).applyAsLong(3);
        System.out.println("l -> l+2  -->> " + l);

        LongUnaryOperator luo2 = m -> m*2;
        long m = luo2.compose(luo2).applyAsLong(3);
        System.out.println("m -> m*2  -->> " + m);
    }
}
