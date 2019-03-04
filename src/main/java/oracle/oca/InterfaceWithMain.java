package oracle.oca;

public class InterfaceWithMain {
    static int x = 10;
    static int z;

    {
        System.out.println("inside block");
    }

    static {
        int x = 20;
        z = x;
        if (true)
            if (true) ;
            else x = 2;
        else ;
    }

    Double dddd;
    char c[] = new char[]{'a', 'd'};
    String s1 = new String(c);

    public InterfaceWithMain(Double d) {
        dddd = d;
        System.out.println("String s = " + s1);
    }

    public void BigLetterMethod() {
        System.out.println("method works!");
    }

    public static void main(String args[]) {
        System.out.println(x + z);
        InterfaceWithMain interfaceWithMain = new InterfaceWithMain(12.2);

        interfaceWithMain.BigLetterMethod();

        interfaceWithMain.x = 3; // static member accessed via instance
        System.out.println(x + " " + Move.value);
        Move.print();

    }

    interface Move {
        Long l = 3L;
        int value = 15;


        public static void main(String[] args) {
            System.out.println("Move");
            Double d = 10 / 0.0;
            Float f = 1.3f;
            Double sd = 1.5;
            int q = 16, w = 3;
            q /= w;
            Integer i = 3;
            System.out.println("equals: " + i.equals(sd) + (q == sd));
            System.out.println("q/=w " + q);

            for (int zd = 1; zd < 10; zd++, System.out.print(zd + "Hi"), System.out.println("yes it works")) ;

            System.out.println(d.isInfinite());
        }

        public static void print() {
        }
    }

}
