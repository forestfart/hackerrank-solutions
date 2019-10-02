package oracle.ocp.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DaylightSavingFun {

    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("America/New_York");
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDate.of(2015,3,8), LocalTime.of(1, 0), zone);
        ZonedDateTime dateTime2 = dateTime.plusHours(2);
        System.out.printf("DateTime: %s DateTime2: %s\n", dateTime, dateTime2);
        System.out.println(DateTimeFormatter.ofPattern("H:mm - ").format(dateTime2) + "difference is: " + ChronoUnit.HOURS.between(dateTime, dateTime2));
    }
}
