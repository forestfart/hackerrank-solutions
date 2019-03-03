package oracle.oca;

import java.time.LocalDate;

interface FourWalls {
    default void methodCommon() {
        LocalDate date = LocalDate.of(2015,3,26);
        System.out.println(date);
    }
}

abstract class House {

    void methodParentClass(FourWalls fourWalls) {
        System.out.println("methodCommon from Dom");
        fourWalls.methodCommon();
    }
}


class Room extends House implements FourWalls {

    public static void main(String[] args){
        Room fourWalls = new Room();
        fourWalls.methodParentClass(fourWalls);
        fourWalls.methodChildClass();

    }

    void methodChildClass() {
        System.out.println("Sciany");
    }

}
