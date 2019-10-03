package oracle.ocp.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOfStreams {
    public static void main(String[] args) {
        Stream<List<String>> iStr = Stream.of(Arrays.asList("1", "John"), Arrays.asList("2", null));
        Stream<String> nInSt = iStr.flatMap(x -> x.stream());
        nInSt.forEach(System.out::print);
    }

}
