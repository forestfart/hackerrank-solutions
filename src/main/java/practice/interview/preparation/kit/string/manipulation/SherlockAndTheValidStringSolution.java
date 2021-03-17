package practice.interview.preparation.kit.string.manipulation;

import java.util.*;

public class SherlockAndTheValidStringSolution {

    // Complete the isValid function below.

    static String isValid(String s) {
        char key;
        int value;
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

        for (Character character : map.keySet()) {
            int occurrence = aggregated.get(map.get(character)) == null ? 0 : aggregated.get(map.get(character));
            occurrence++;
            aggregated.put(map.get(character), occurrence);
        }
        int i1, i2;
        if (aggregated.size() == 1) {
            return "YES";
        } else if (aggregated.size() == 2) {
            Iterator<Integer> iterator = aggregated.keySet().iterator();
            i1 = iterator.next();
            i2 = iterator.next();
            if ((aggregated.get(i1) == 1 && Math.abs(i1 - i2) < 2) || (aggregated.get(i2) == 1 && Math.abs(i1 - i2) < 2)) {
                return "YES";
            }
            if ((i1 == 1 && aggregated.get(i1) == 1) || (i2 == 1 && aggregated.get(i2) == 1)) {
                return "YES";
            }
        }
        return "NO";
    }
}
