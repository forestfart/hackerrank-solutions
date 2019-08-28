package oracle.ocp.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeParseBugCheck<T,D,E> {
    public static void main(String[] args) {
        String date = "1-2020-3-1 11:28 PM";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Q-u-M-d h:m a");
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("d MMMM yyyyG h 'godzina' m 'minut.'")));
    }

}
