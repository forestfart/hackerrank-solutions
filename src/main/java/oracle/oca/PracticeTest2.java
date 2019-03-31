package oracle.oca;

public class PracticeTest2 {
    public static void main(String... s) {
        double d = 10.0 / 0.0;
        System.out.println(d);

        double e = 10 / 0.0;
        System.out.println(e);

        double f = 10.0 / 0;
        System.out.println(f);

        float g = 10.0f / 0.0f;
        System.out.println(g);

        float h = 10 / 0.0f;
        System.out.println(h);

        float i = 10.0f / 0;
        System.out.println(i);

        // --> all prints "Infinity"
    }
}
