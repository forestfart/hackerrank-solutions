package oracle.ocp.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OfNullableTest {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("OCAJP", "OCA", "OCM");

        Optional<String> optionalString = stream.findAny();

        optionalString.ofNullable(null).ifPresent(System.out::println); // <<- xD brain damage!
        Optional.ofNullable(optionalString).ifPresent(System.out::println);

        System.out.println(optionalString);
    }

}
