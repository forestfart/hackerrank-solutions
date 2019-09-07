package oracle.ocp.assertions;

public class StaticAssertion {

    static {
        int count = 5;
        assert count++ == 6;
        if(count == 5) System.out.println("Assertions are disabled in StaticAssertion class");
        System.out.println(count);
    }

    public static void main(String[] args) {                        // to be run with -ea in VM options if we want to enable assertions
        AnotherClassInThisPackageWithSomeAssertion.assertShit();    // run with: -ea:oracle.ocp.assertions... -da:oracle.ocp.assertions.StaticAssertion
                                                                    // or: -ea:oracle.ocp.assertions.AnotherClassInThisPackageWithSomeAssertion -da:oracle.ocp.assertions.StaticAssertion
    }

}