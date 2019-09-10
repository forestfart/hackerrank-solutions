package oracle.ocp.clazz;

interface Mother {}

class ShitItself {}

class ItWontCompile {}

class HeavyAnimal implements Mother {} //fin it this is a class

class Hippo extends HeavyAnimal {}

public class InstanceOfCheck {

    public static void main(String[] args) {
        Mother hippo = new Hippo();

        System.out.println(hippo instanceof HeavyAnimal);

        System.out.println(hippo instanceof ItWontCompile); // if class Hippo extends HeavyAnimal then it will not compile
    }

}
