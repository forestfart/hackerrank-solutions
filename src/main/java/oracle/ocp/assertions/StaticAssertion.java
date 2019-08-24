package oracle.ocp.assertions;

public class StaticAssertion {

    static {
        boolean assertsEnabled = false;
        assert assertsEnabled = true;
        if(!assertsEnabled) throw new RuntimeException("Stop!!");
    }

    public static void main(String[] args) {}  // to be run with -ea in VM options if we want to enable assertions

}
