package oracle.ocp.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String args[]) {

        Optional<Integer> optionalInteger = Optional.of(9);

        optionalInteger.filter(p -> p > 8).ifPresent(System.out::print);
    }

}
