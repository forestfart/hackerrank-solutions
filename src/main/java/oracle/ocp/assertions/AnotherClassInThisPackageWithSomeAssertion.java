package oracle.ocp.assertions;

class AnotherClassInThisPackageWithSomeAssertion {
    static void assertShit() {
        assert false: "Assertion enabled in the other class of this package";
        System.out.println();
    }
}
