package oracle.ocp;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Lambda {
    public static void main(String[] args) {
        Consumer<String> lambdaFunction = System.out::println;
        lambdaFunction.accept("the Message");

        BiConsumer<Integer, Integer> nice = (a, b) -> System.out.println(a * b);
        nice.accept(10,10);
    }
}
