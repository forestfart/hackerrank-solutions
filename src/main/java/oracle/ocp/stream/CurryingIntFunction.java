package oracle.ocp.stream;

import java.util.function.BiFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class CurryingIntFunction {

    public static void main(String[] args) {
        IntStream stream = IntStream.of(1,2,3);
        BiFunction<Integer, Integer, IntUnaryOperator> intFunction = (y, z) -> x -> x * y + z;

        IntStream newStream = stream.map(intFunction.apply(10, 16));
        newStream.forEach(System.out::println);
    }
}
