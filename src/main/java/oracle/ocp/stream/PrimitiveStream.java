package oracle.ocp.stream;

import java.util.stream.IntStream;

public class PrimitiveStream {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(3,6);

        intStream.forEach(x -> {
            x += 2;
            System.out.println(x);
        });
    }
}
