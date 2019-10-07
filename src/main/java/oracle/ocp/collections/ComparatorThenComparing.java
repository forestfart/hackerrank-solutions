package oracle.ocp.collections;

import oracle.ocp.collections.TreeSetFun.Vehicle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    String firstName;
    String lastName;

    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.lastName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + ':' + lastName;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Smith"),
                new Employee("Alan", "Parks"),
                new Employee("Jan", "Kowalski"),
                new Employee("Natalia", "Mak"),
                new Employee("Marcin", "Nowak"),
                new Employee("Jan", "Cool"),
                new Employee("Madeleine", "Smith"));
        List<Employee> employeesSorted  = employees.stream()
                .sorted(Comparator.comparing((Employee e) -> e.firstName).reversed().thenComparing((Employee e) -> e.lastName))
                .collect(Collectors.toList());
        System.out.println(employeesSorted);
    }
}

public class ComparatorThenComparing {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = Arrays.asList(
                new Vehicle(1, "Mazda"),
                new Vehicle(2, "Bentley"),
                new Vehicle(1, "Aaston"),
                new Vehicle(1, "Zator"),
                new Vehicle(2, "Umor"),
                new Vehicle(5, "Kamaz"),
                new Vehicle(1, "Ferrari"),
                new Vehicle(5, "Citroen"));

        Stream<Vehicle> vehicleStream = vehicleList.stream()
                .filter(n -> n.getName().contains("a"))
                .sorted(Comparator.comparing(Vehicle::getId).thenComparing(Vehicle::getName));
        List<Vehicle> newList = vehicleStream.collect(Collectors.toList());
        System.out.println(newList);

        vehicleList.sort(Comparator.comparing(Vehicle::getId));
        System.out.println(vehicleList);

        vehicleList.sort(Comparator.comparing((Vehicle v) -> v.getId()).thenComparing(Vehicle::getName));  // << need to cast to Vehicle inside Comparator function, can be method reference
        System.out.println(vehicleList);
    }
}
