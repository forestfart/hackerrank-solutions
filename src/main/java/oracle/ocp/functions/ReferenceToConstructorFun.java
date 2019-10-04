package oracle.ocp.functions;

interface Rideable {
    Car getCar(String name);
}
class Car {
    private String name;
    public Car (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface Cycleable {
    Bike getBike();
}
class Bike {
    public Bike() {
    }
}

public class ReferenceToConstructorFun {
    public static void main(String[] args) {
        Cycleable bike = () -> new Bike();
        Cycleable bikeCycleable = Bike::new;
        Rideable autoLambda = str -> new Car(str);
        Rideable autoConstructorReference = Car::new;
        System.out.println(autoConstructorReference.getCar("Vehicle").getName());
    }
}
