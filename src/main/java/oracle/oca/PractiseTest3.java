package oracle.oca;

public class PractiseTest3 {
    int i = 10;
    public static void main(String args[]) throws Exception {
        System.out.format("%02d", 12452);
        int i = 2;
        PractiseTest3 pt3 = new PractiseTest3();
        i = 6;
        System.out.println(" " + pt3.i);
    }
}

class PractiseTest4 {
    int i;
    public static void main(String[] args) {
        System.out.format("%112d", 12452);
        //int i;
        System.out.println(new PractiseTest4().i);
    }
}

class PractiseTest5 {
    public static void main(String... args) {
        System.out.format("%06d", 12452);

        if (false) System.out.println(true);
        else System.out.println(false);

        System.out.println();
        double d = 20/10;

        int octal = 012;
        System.out.println("octal = " + octal);
        System.out.println(false);
        System.out.println(Moonish.s);
        System.out.println(Moonish.gf);

        Moonish moonish = new Moonish() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }
}

interface Moonish {
    String s = "moonish df";
    static String gf = "moonish l"; //<<- redundant!
}

