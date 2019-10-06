package oracle.ocp.collections;

import java.util.Set;
import java.util.TreeSet;

class Vehicle implements Comparable<Vehicle> {
    int id;
    String name;

    public Vehicle(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Vehicle vehicle) {
        return this.id > vehicle.id ? 1 : this.id < vehicle.id ? -1 : 0;
    }
}

public class TreeSetFun {
    public static void main(String[] args) {
        Set<Vehicle> vehicles = new TreeSet<>();
        vehicles.add(new Vehicle(212, "Noname"));
        vehicles.add(new Vehicle(342, "Yetiii"));
        vehicles.add(new Vehicle(342, "Montii"));
        vehicles.add(new Vehicle(2, "Montahnanana"));

        System.out.println(vehicles);

    }
}
