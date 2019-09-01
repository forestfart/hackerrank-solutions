package oracle.ocp.locale;

import java.util.Locale;

public class LocaleInstancesCheck {
    public static void main(String[] args) {
        Locale inLocale = Locale.TRADITIONAL_CHINESE;
        Locale.setDefault(Locale.TRADITIONAL_CHINESE);

        Locale canada = Locale.CANADA;
        System.out.println(canada.getDisplayCountry(inLocale));

        Locale catalonian = new Locale("ca", "CA");
        System.out.println(catalonian.getDisplayCountry(inLocale));
        System.out.println(catalonian.getDisplayLanguage(inLocale));  // << katalonski!

        Locale loc = new Locale.Builder().build();
        System.out.println(loc.getDisplayLanguage(new Locale("En")));
        System.out.println(loc.getDisplayCountry(new Locale("En")));

    }

}
