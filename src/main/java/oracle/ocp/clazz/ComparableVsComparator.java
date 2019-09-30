package oracle.ocp.clazz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class VehicleComparable implements Comparable {
    private int id;
    private String name;

    public VehicleComparable(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "VehicleComparable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class VehicleComparator implements Comparator {
    private int id;
    private String name;

    public VehicleComparator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "VehicleComparator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ComparableVsComparator {
    public static void main(String[] args) {
        List<VehicleComparable> comparableList = Arrays.asList(
                new VehicleComparable(1, "Bob"),
                new VehicleComparable(3, "Aston"),
                new VehicleComparable(2, "Celine"));
        List<VehicleComparator> comparatorList = Arrays.asList(
                new VehicleComparator(1, "Bob,"),
                new VehicleComparator(3, "Aston"),
                new VehicleComparator(2, "Celine"));

        comparableList.stream().sorted(Comparator.comparing(VehicleComparable::getName)).forEach(System.out::println);

        comparatorList.stream().sorted(Comparator.comparing((VehicleComparator n) -> n.getId())).forEach(System.out::println);

        comparableList.stream().sorted().forEach(System.out::println);

        // comparatorList.stream().sorted().forEach(System.out::println); <<- class cast exception: cannot cast to Comparable


    }
}
