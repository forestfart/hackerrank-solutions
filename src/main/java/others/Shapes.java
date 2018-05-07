package others;

import java.util.*;


// factory pattern
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.print('o');
    }
}

class Line implements Shape {
    @Override
    public void draw() {
        System.out.print('l');
    }
}

public class Shapes {

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle());
        shapeList.add(new Line());

        for (Shape shape : shapeList) {
            shape.draw();
        }
    }
}