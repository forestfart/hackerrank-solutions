package oracle.oca;

public class PractiseTest3 {
    public static void main(String args[]) {
        System.out.format("%0112d", 12452);
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
