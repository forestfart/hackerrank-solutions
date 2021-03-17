package practice.interview.preparation.kit.string.manipulation;

import java.util.*;

public class SherlockAndTheValidStringSolution {

    // Complete the isValid function below.

    static String isValid(String s) {
        Character key;
        Integer value;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            key = s.charAt(i);
            if (map.get(key) == null) {
                map.put(key, 1);
            } else {
                value = map.get(key);
                map.put(key, ++value);
            }
        }
        Map<Integer, Integer> aggregated = new HashMap<>();
        map.keySet().forEach(character -> {
                    int occur = aggregated.get(map.get(character)) == null ? 0 : aggregated.get(map.get(character));
                    aggregated.put(map.get(character), ++occur);
                });
        if (aggregated.size() == 1) {
            return "YES";
        } else if (aggregated.size() == 2) {
            Iterator<Integer> iterator = aggregated.keySet().iterator();
            int i1 = iterator.next();
            int i2 = iterator.next();
            if (Math.abs(i1 - i2) < 2 && (aggregated.get(i1) == 1 || (aggregated.get(i2) == 1))) {
                return "YES";
            }
            if ((i1 == 1 && aggregated.get(i1) == 1) || (i2 == 1 && aggregated.get(i2) == 1)) {
                return "YES";
            }
        }
        return "NO";
    }
}
