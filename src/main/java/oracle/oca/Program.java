package oracle.oca;

import javafx.util.converter.LocalDateTimeStringConverter;

import static java.lang.System.*;

import java.io.IOException;
import java.util.ArrayList;

public class Program {
    static {
        out.println("Static");
    }

    static int $ = 6;
    static int _6 = 3;

    {
        out.println("Block");
        ddd = 43;
        ggg = 5;
        byte b = 20;
        short s = 30000;
        long l = 2000000000000000000l;
        float g = 4;
        float hj = b + s + l + g;
        out.println("--->>>>>>>>>>>>> strzala rowna sie:" + hj);
    }

    int ddd = 10;
    static int ggg; // if final -> compilation error

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Program().dolt();
        int $_ = 3;
        out.println($_);
    }

    static void dolt() throws IOException, ClassNotFoundException {
        String s = "";
        final int ooo;
        int[] ints = new int[12];
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.set(0, new LocalDateTimeStringConverter());
        arrayList.add(1, new Integer(4));
        for (int x = 017, y = 6; x-- > y; ) {
            continue;
        }
        out.println("=----->>> instance: " + (new Program() instanceof Object));
        for (int x = 10, y = 6; x > y; out.println(x--)) {
            s += x;
            out.println(Program._6);
        }
        out.println("works! s = " + s);

        ooo = 2;
        out.print(ooo);
        double dasdf = 10 / 3;
        out.println(" Divideee in floting context:  " + dasdf);

        Double ii = 10.0;
        out.println("comparing: " + (new Integer(10).equals(ii)));
        out.println("comparing: " + (ii == 10));
        out.println("comparing: " + (ii == 10));

        int ddd = 1;
        out.print(ddd);
        loop:
        for (; ; ) {
            break loop;
        }
        out.println("" + (true ^ false) + " bitwise compliment of 6 is " + ~_6);

        for (int dx = 0; dx < 5; out.println(dx), dx++) {
            out.println("looping: " + dx);
            int sss = 1;
            sss++;
            out.print(sss);
        }
        double[] dou = {1, 3.2, 3, 2.0};
        out.println(dou[2] + dou[1]);

        final int ggg = 4;

        for (int dd = 2; dd < 10; dd++) {
            switch (dd) {
                case 2:
                    out.println("switch 2 passed");
                    break;
                case ggg:
                    out.println("switch 4 passed");
            }
        }

        double a = 1.0;
        long b = 12;

        boolean dd = a == b;  // condition always false

    }
}
