package oracle.ocp.stream;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class CurryingIntFunction {

    public static void main(String[] args) {
        IntStream stream = IntStream.of(1,2,3);
        IntFunction<IntUnaryOperator> intFunction = x -> y -> x * y;

        IntStream newStream = stream.map(intFunction.apply(10));
        newStream.forEach(System.out::println);
    }
}
