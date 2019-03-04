package oracle.oca;

public class InterfaceWithMain {

    public static void main(String args[]) {

        Move.print();
    }

    interface Move {
        public static void main(String[] args) {
            System.out.println("Move");
        }
        public static void print(){}
    }
}
