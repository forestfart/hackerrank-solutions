package oracle.oca;

public class PractiseTest3 {
    int i;
    public static void main(String args[]) {
        System.out.format("%02d", 12452);
        PractiseTest3 pt3 = new PractiseTest3();
        System.out.println(" " + pt3.i);
    }
}

class PractiseTest4 {
    public static void main(String[] args) {
        System.out.format("%112d", 12452);
    }
}

class PractiseTest5 {
    public static void main(String... args) {
        System.out.format("%06d", 12452);
    }
}
