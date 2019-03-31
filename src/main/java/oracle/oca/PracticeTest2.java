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

        Double j = 10.0 / 0.0;
        System.out.println(j.isInfinite());

        Float k = 10.0F / 0;
        System.out.println(k.isInfinite());

        // --> all prints "Infinity"
    }
}
