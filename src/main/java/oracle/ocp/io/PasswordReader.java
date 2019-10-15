package oracle.ocp.io;

import java.io.Console;

public class PasswordReader {
    public static void main(String[] args) {

        Console console = System.console();

        char[] pass = console.readPassword("Enter password");  // line n1
        String password = new String(pass);                         // line n2;
    }
}
