package oracle.ocp.functions;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CurryingTest {

    public static void main(String[] args) {
        BinaryOperator add = (a, b) -> (int)a + (int)b;
        System.out.println("Simple addition: " + add.apply(1,2) );

        IntFunction<IntUnaryOperator> curriedAdd = a -> b -> a + b;
        System.out.println("Curried add: " + curriedAdd.apply(1).applyAsInt(3));
        method();
        methodPrimitive();
    }

    private static void method() {
        Stream<Integer> stream = Stream.of (1,2,3);
        Function<Integer, UnaryOperator<Integer>> inFu = x -> y -> x * y;
        Stream<Integer> newStream = stream.map(inFu.apply(10));
        newStream.forEach(System.out::print);
    }

    private static void methodPrimitive() {
        IntStream stream = IntStream.of (1,2,3);
        IntFunction<IntUnaryOperator> inFu = x -> y -> x * y;
        IntStream newStream = stream.map(inFu.apply(10));
        newStream.forEach(System.out::print);
    }
}
