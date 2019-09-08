package oracle.ocp;

import java.io.IOException;
import java.io.InputStream;

public class SystemInTest {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[10];

        InputStream in = System.in;
        int i = in.read(b);

        for (byte c : b) {
            System.out.print((char)c);
        }
        in.close();
    }

}
