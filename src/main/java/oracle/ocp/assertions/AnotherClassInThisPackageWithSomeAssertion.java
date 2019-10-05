package oracle.ocp.assertions;

import java.io.Console;
class AnotherClassInThisPackageWithSomeAssertion {
    static void assertShit() {
        assert false: "Assertion enabled in the other class of this package";
        System.out.println();
    }

    public static void main(String[] args) {
        assert true: "NISD";
        Console con = System.console();
        char[] pass = con.readPassword();
        String password = new String(pass);
    }
}
