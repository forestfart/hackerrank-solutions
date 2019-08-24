package oracle.ocp.assertions;

public class ArgsNullCheck {

    public static void main(String[] args) {
        assert args != null : "Null";
        System.out.println("OK + " + args + "");
    }

}
