package oracle.ocp.time;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantFun {
    public static void main(String[] args) throws InterruptedException {
        Instant login = Instant.now();
        Thread.sleep(1000);
        Instant logout = Instant.now();

        Instant loginTime = login.truncatedTo(ChronoUnit.MINUTES);
        Instant logoutTime = logout.truncatedTo(ChronoUnit.MINUTES);

        if (logoutTime.isBefore(loginTime.plus(1, ChronoUnit.MINUTES))) {
            System.out.println("Login: " + loginTime);
        } else {
            System.out.println("Can't login");
        }
    }
}
