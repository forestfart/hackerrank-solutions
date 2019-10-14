package oracle.ocp.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamWillNotFlow {
    public static void main(String[] args) {
        List<String> nL = Arrays.asList("Jim", "John", "Jeff");
        Function<String, String> funVal = "Hello : "::concat;
        nL.stream()
                .map(funVal)
                .peek(System.out::print);
    }
}
