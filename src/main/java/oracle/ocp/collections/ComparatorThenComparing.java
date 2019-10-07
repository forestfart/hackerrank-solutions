package oracle.ocp.collections;

import oracle.ocp.collections.TreeSetFun.Vehicle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
