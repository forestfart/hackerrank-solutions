package oracle.ocp.clazz;

public class LocalInnerClassTest {
    private int length = 5;

    private void calculate() {
        final int width = 20;

        class Inner {
            private void multiply() {
                System.out.println(length * width);
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        LocalInnerClassTest outer = new LocalInnerClassTest();
        outer.calculate();
    }
}

class Vehicle {
    int distance; //line n1
    Vehicle (int x) {
        this.distance = x;
    }
    public void increaseSpeed(int time) { //line n2
        int timeTravel = time; //line n3
        class Car {
            int value = 0;
            public void speed () {
                value = distance / timeTravel;
                System.out.println ("Velocity with new speed " + value +" kmph");
            }
        }
        new Car().speed();
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle(100);
        v.increaseSpeed(60);
    }
}
