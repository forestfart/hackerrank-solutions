package oracle.ocp.optional;

import java.util.Optional;
import java.util.stream.Stream;

class Employee {
    Optional<Address> address;
    Employee (Optional<Address> address) {
        this.address = address;
    }
    public Optional<Address> getAddress() {
        return address;
    }
}

class Address {
    String city = "New York";
    public String getCity() {
        return city;
    }

    public String toString() {
        return city;
    }

    public static void main(String[] args) {
        Address address = null;
        Optional<Address> address1 = Optional.ofNullable(address);
        Employee e1 = new Employee(address1);
        System.out.println((address1.isPresent()) ? address1.get().getCity() : "City Not available");
    }
}


public class OfNullableTest {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("OCAJP", "OCA", "OCM");

        Optional<String> optionalString = stream.findAny();

        optionalString.ofNullable(null).ifPresent(System.out::println); // <<- xD brain damage! does not trigger Sys.out, static member accessed via instance reference
        Optional.ofNullable(optionalString).ifPresent(System.out::println);

        System.out.println(optionalString);
    }

}
