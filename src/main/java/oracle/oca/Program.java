package oracle.oca;

import static java.lang.System.*;

import java.io.IOException;

public class Program {
    int ddd = 10;
    static int _6 = 6;
    {
        out.println("Block");
    }

    static {
        out.println("Static");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Program().dolt();
    }

    static void dolt() throws IOException, ClassNotFoundException {
        String s = "";
        int[] ints = new int[12];
        for (int x = 017, y = 6; x-- > y; ) {
            continue;
        }
        for (int x = 10, y = 6; x > y; out.println(x--)) {
            s += x;
            out.println(Program._6);
        }
        out.println("works! s = " + s);

        Double ii = 10.0;
        out.println("comparing: " + (new Integer(10).equals(ii)));
        out.println("comparing: " + (ii == 10));
        out.println("comparing: " + (ii == 10));

        loop:
        for (; ; ) {
            break loop;
        }
        out.println("" + (true^false) + " bitwise compliment of 6 is " + ~_6);

    }
}
