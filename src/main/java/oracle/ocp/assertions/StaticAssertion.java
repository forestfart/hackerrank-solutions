package oracle.ocp.assertions;

public class StaticAssertion {

    static {
        int count = 5;
        assert count++ == 6;
        if(count == 5) throw new RuntimeException("Assertions are disabled!");
        System.out.println(count);
    }

    public static void main(String[] args) {}  // to be run with -ea in VM options if we want to enable assertions

}