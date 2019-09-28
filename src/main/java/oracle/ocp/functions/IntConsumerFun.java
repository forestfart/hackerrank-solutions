package oracle.ocp.functions;


import java.util.function.Function;
import java.util.function.IntConsumer;

public class IntConsumerFun {
    public static void main(String[] args) {
        IntConsumer consumer = System.out::println;
        Integer value = 90;
        Function<Integer, Integer> fun = e -> e + 10;
        Integer result = fun.apply(value);
        consumer.accept(result);
    }
}
