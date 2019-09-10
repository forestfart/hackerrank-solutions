package oracle.ocp.clazz;

class ItWontCompile {}

interface HeavyAnimal {} //fin it this is a class

class Hippo implements HeavyAnimal {}

public class InstanceOfCheck {

    public static void main(String[] args) {
        HeavyAnimal hippo = new Hippo();

        System.out.println(hippo instanceof HeavyAnimal);

        System.out.println(hippo instanceof ItWontCompile); // if class Hippo extends HeavyAnimal then it will not compile
    }

}
