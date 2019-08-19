package oracle.ocp.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.Duration.between;

public class ChronoUnitsCheck {

    public static void main(String[] args) {
        LocalDateTime localDate1 = LocalDateTime.of(2019,10, 28, 0, 0);
        LocalDateTime localDate2 = LocalDateTime.of(2019,10,29, 0, 0);

        long l = localDate1.until(localDate2, ChronoUnit.HALF_DAYS);
        System.out.println(l);

        Duration duration = between(localDate1, localDate2);
        System.out.printf("Duration between %s and %s is %s %s", localDate1, localDate2, duration, duration.getUnits());

    }
}
