package oracle.ocp.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedHello {
    public static void main(String args[]) {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle resBundle = ResourceBundle.getBundle("ResourceBundle", currentLocale);
        System.out.println(resBundle.getString("Greeting"));

        currentLocale = Locale.ITALIAN;
        ResourceBundle resourceBundleIt = ResourceBundle.getBundle("ResourceBundle", currentLocale);
        System.out.println(resourceBundleIt.getString("Greeting"));
    }
}
