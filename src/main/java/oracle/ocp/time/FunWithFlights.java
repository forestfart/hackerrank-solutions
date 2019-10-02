package oracle.ocp.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class FunWithFlights {

    public static void main(String[] args) {
        ZonedDateTime departure = ZonedDateTime.of(2018,2,5,10,35,0,0, ZoneId.of("UTC+1"));
        ZonedDateTime arrival = ZonedDateTime.of(2018,2,6,22,30,0,0, ZoneId.of("Australia/Sydney"));
        System.out.printf("Flight duration is %s hours", ChronoUnit.HOURS.between(departure, arrival));
    }
}
