package oracle.ocp.clazz;

public final class InheritanceFun {
    public void prepare() {
    }
}

class Cake {
    void bake(int min, int temp) {
    }

    public void mix() {
    }
}

class Shop {
    private Cake c = new Cake();
    private final double discount = 0.25;

    public void makeReady() {
        c.bake(10, 120);
    }
}

class Bread extends Cake {
    public void bake(int minutes, int temperature) {
    }

    public void addToppings() {
    }
}

abstract class Operator {
    protected abstract void turnOn();

}

abstract class Shape {
    Shape() {
        System.out.println("Shape");
    }

    protected void area() {
        System.out.println("Shape");
    }
}

class Square extends Shape {
    int side;

    Square(int side) {
        /* insert code here */
        this.side = side;
    }

    public void area() {
        System.out.println("Square");
    }
}

class Rectangle extends Square {
    int len, br;

    Rectangle(int x, int y) {
        super(x);
        len = x; br = y;
    }

    public void area() {
        System.out.println("Rectangle");
    }
}


