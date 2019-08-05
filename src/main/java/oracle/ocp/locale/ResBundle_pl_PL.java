package oracle.ocp.locale;

import java.util.ListResourceBundle;

// default US English version
public class ResBundle_pl_PL extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            { "MovieName", "Avatar + napisy pl" },
            { "GrossRevenue", (Long) 2782275172L }, // in US dollars
            { "Year", (Integer)2009 }
    };
}
