package oracle.ocp.time;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ZoneIdTest {

    public static void main(String[] args) {
        Map<String, String> sid = new TreeMap<>(ZoneId.SHORT_IDS);
        sid.put("ZZZ", "Australia/Sydney");

        ZoneId z = ZoneId.of("ZZZ", sid);
        sid.forEach((k,v) -> System.out.println(k + " " + v));
        System.out.println("\n" + z);
    }
}
