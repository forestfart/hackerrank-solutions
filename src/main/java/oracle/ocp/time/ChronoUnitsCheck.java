package oracle.ocp.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitsCheck {

    public static void main(String[] args) {
        LocalDateTime localDate1 = LocalDateTime.of(2019,10, 28, 0, 0);
        LocalDateTime localDate2 = LocalDateTime.of(2019,10,29, 0, 0);

        long l = localDate1.until(localDate2, ChronoUnit.HALF_DAYS);

        System.out.println(l);
    }
}
