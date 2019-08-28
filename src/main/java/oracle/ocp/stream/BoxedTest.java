package oracle.ocp.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoxedTest {

    public static void main(String[] args) {
        IntStream ints = IntStream.of(5, 10, 15);
        Stream<String> stngs = ints.boxed().map(Object::toString); // <- ambigous method reference if we do .map(Integer::toString)
        System.out.println(stngs.findAny());

    }
}
