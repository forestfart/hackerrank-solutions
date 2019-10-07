package oracle.ocp.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OrElseFun {
    public static Optional<String> getCountry(String location) {
        Optional<String> countryName = Optional.empty();
        if ("Sydney".equals(location)) {
            countryName = Optional.of("Australia");
        } else if ("Munich".equals(location)) {
            countryName = Optional.of("Germany");
        }
        return countryName;
    }

    public static void main(String[] args) {
        Optional<String> city1 = getCountry("Sydney");
        System.out.println(city1);
        Optional<String> city2 = getCountry("London");
        System.out.println(city2);
        System.out.println(city1.orElse("Not Found"));
        if (city2.isPresent()) {
            city2.ifPresent(System.out::println);
        } else {
            System.out.println(city2.orElse("Not Found2"));
        }
    }
}
