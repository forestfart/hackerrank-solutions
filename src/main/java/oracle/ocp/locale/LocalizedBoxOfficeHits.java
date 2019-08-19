package oracle.ocp.locale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

public class LocalizedBoxOfficeHits {
    public void printMovieDetails(ResourceBundle resBundle) {
        String movieName = resBundle.getString("MovieName");
        Long revenue = (Long)(resBundle.getObject("GrossRevenue"));
        Integer year = (Integer) resBundle.getObject("Year");

        System.out.println("Movie " + movieName + "(" + year + ")" + " grossed "
                + revenue );
    }

    public static void main(String args[]) {
        LocalizedBoxOfficeHits localizedHits = new LocalizedBoxOfficeHits();
        // print the largest box-office hit movie for default (US) locale
        Locale locale = Locale.getDefault();

        Control resourceBundleControl = Control.getControl(Control.FORMAT_CLASS); // cases: Control.FORMAT_CLASS, Control.FORMAT_DEFAULT, Control.FORMAT_PROPERTIES <- last one will throw exception here
        localizedHits.printMovieDetails(ResourceBundle.getBundle("oracle.ocp.locale.ResBundle", locale, resourceBundleControl));

        // print the largest box-office hit movie for Italian locale
        locale = new Locale("en", "EN", "");
        localizedHits.printMovieDetails(ResourceBundle.getBundle("oracle.ocp.locale.ResBundle", locale, resourceBundleControl));
    }
}
