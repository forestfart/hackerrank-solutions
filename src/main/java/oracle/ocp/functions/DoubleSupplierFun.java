package oracle.ocp.functions;

import java.util.function.DoubleSupplier;

public class DoubleSupplierFun {
    String name;
    Integer cost;

    DoubleSupplierFun(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    String getName() {
        return name;
    }

    int getCost() {
        return cost; // <<--- NullPointerException thrown here.
    }

    public static void main(String[] args) {
        DoubleSupplierFun j1 = new DoubleSupplierFun("IT", null);
        DoubleSupplier jS1 = j1::getCost;
        System.out.println(j1.getName() + ":" + jS1.getAsDouble());
    }

}
