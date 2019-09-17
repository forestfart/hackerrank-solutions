package oracle.ocp.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntConsumerTest {
    public static void main(String[] args) {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        stream.forEach(x -> {
                    x = x + 100;
                    System.out.print(x);
                }
        );
        System.out.println("\n------");

        Stream<Integer> stream1 = Stream.of(1,2,3,4);
        stream1.forEach(x -> {
            x = x + 2;
            System.out.print(x);
        });
    }
}
