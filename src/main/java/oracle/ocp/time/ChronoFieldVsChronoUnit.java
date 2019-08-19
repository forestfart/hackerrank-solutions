package oracle.ocp.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class ChronoFieldVsChronoUnit {

    public static void main(String[] args) {
        LocalDateTime lt = LocalDateTime.of(1059,11,11,11,22);

        System.out.println(lt.isSupported(ChronoField.MILLI_OF_SECOND));
        System.out.println(lt.isSupported(ChronoUnit.CENTURIES));
    }
}
