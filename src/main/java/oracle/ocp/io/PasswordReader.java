package oracle.ocp.io;

import java.io.Console;

public class PasswordReader {
    public static void main(String[] args) {

        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        char[] pass = console.readPassword("Enter password");  // line n1
        String password = new String(pass);                         // line n2;
    }
}
