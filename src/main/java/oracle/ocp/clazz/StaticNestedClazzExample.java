package oracle.ocp.clazz;

public class StaticNestedClazzExample {

    static class Nested {
        private int price = 6;
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }

}

