package others;

interface BaseInterface {
    default void display() {
        System.out.println("Java 8 diamond problem kind of a solution");
    }
}

interface BaseOne extends BaseInterface {
}

interface BaseTwo extends BaseInterface {
}

public class DiamondProblemSolutionSinceJava8 implements BaseOne, BaseTwo {

    public void display() {
        BaseTwo.super.display();
    }

    public static void main(String[] args) {
        new DiamondProblemSolutionSinceJava8().display();
    }
}

