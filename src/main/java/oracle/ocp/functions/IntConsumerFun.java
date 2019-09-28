package oracle.ocp.functions;

import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;

public class IntConsumerFun {
    public static void main(String[] args) {
        IntConsumer consumer = System.out::println;
        Integer value = 90;
        ToIntFunction<Integer> fun = e -> e + 10;
        int result = fun.applyAsInt(value);
        consumer.accept(result);
    }
}
