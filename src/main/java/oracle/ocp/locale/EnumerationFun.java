package oracle.ocp.locale;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class EnumerationFun {
    public static void main(String[] args) {
        Enumeration<String> names = ResourceBundle.getBundle("sdf").getKeys();
    }
}
