package oracle.ocp.locale;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

class TalkativeResourceBundleControl extends ResourceBundle.Control {
    // override the default getCandidateLocales method to print
    // the candidate locales first
    public List<Locale> getCandidateLocales(String baseName, Locale locale) {
        List<Locale> candidateLocales = super.getCandidateLocales(baseName, locale);
        System.out.printf("Candidate locales for base bundle name %s and locale %s %n", baseName, locale.getDisplayName());
        candidateLocales.forEach(System.out::println);
        return candidateLocales;
    }
}

class CandidateLocales {
    public static void loadResourceBundle(String resourceBundleName, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceBundleName, locale, new TalkativeResourceBundleControl());
        String rbLocaleName = resourceBundle.getLocale().toString();
        if (rbLocaleName.equals("")) {
            System.out.println("Loaded the default property file with name: "
                    + resourceBundleName);
        } else {
            System.out.println("Loaded the resource bundle for the locale: "
                    + resourceBundleName + "_" + rbLocaleName);
        }
        System.out.println(resourceBundle.getString("Greeting"));
    }

    public static void main(String[] args) {
        Locale locale = Locale.GERMAN;
        //locale = new Locale("de", "DE");
        locale = new Locale.Builder().setLanguage("de").setRegion("DE").build();
        loadResourceBundle("ResourceBundle", locale);
    }
}
