package oracle.ocp.locale;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;


public class NumberFormatFun {
    public static void main(String[] args) {
        Double doubleValue = 15.00;
        BigDecimal value = new BigDecimal(doubleValue);
        Locale localeUs = new Locale("en", "US");
        NumberFormat numberFormatterForUS = NumberFormat.getCurrencyInstance(localeUs);
        NumberFormat numberFormatDefault = NumberFormat.getCurrencyInstance();
        NumberFormat percentageFormat = NumberFormat.getPercentInstance();
        System.out.println(numberFormatterForUS.format(value));
        System.out.println(numberFormatDefault.format(value));
        System.out.println(percentageFormat.format(value));
    }

}
