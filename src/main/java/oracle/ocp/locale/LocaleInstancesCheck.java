package oracle.ocp.locale;

import java.util.Locale;

public class LocaleInstancesCheck {
    public static void main(String[] args) {
        Locale canada = Locale.CANADA;
        System.out.println(canada.getDisplayCountry());

        Locale catalonian = new Locale("ca", "CA");
        System.out.println(catalonian.getDisplayCountry());
        System.out.println(catalonian.getDisplayLanguage());  // << katalonski!
    }

}
