package oracle.ocp.functions;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicateTest {
    public static void main(String[] args) {
        BiPredicate<String, String> biPredicate = (String s1, String s2) -> s1.contains("BR") && s2.contains("JAVA");
        BiFunction<String, String, Integer> function = (s1, s2) -> {
            int fun = 0;
            if (biPredicate.test(s1, s2)) {
                fun = 100;
            }
            return fun;
        };
        System.out.println(function.apply("BREAK THE", "JAVA CODE"));
    }
}

