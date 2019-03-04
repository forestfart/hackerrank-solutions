package oracle.oca;

import java.time.LocalDate;

interface FourWalls {
    default void methodCommon() {
        LocalDate date = LocalDate.of(2015, 3, 26);
        System.out.println(date);
    }
}

abstract class House {
    public House() {
        this("cat in it! woohoo!");
    }

    public House(String s) {
        System.out.println(s);
    }

    abstract void methodChildClass();

    void methodParentClass() {
        System.out.println("methodCommon from House");
        methodChildClass();
    }
}

class Room extends House implements FourWalls {

    public Room() {
        super();
    }

    public static void main(String[] args) {

        Room room = new Room();
        room.methodParentClass();
    }

    void methodChildClass() {
        System.out.println("Walls");
        methodCommon();
    }

}
