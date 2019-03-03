package oracle.oca;

import static java.lang.System.*;

import java.io.IOException;

public class Program {

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
        for (int x = 10, y = 6; x-- > y; ) {
            continue;
        }
        for (int x = 10, y = 6; x > y; out.println(x--)) {
            s += x;
            out.println(Program._6);
        }
        out.println("works! s = " + s);

        loop:
        for (; ; ) {
            break loop;
        }
        out.println("" + (true^false) + " bitwise compliment of 6 is " + ~_6);

    }
}
