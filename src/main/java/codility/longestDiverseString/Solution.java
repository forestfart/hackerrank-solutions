package codility.longestDiverseString;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public String solution(int A, int B, int C) {
        // write your code in Java SE 8

        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", A);
        map.put("b", B);
        map.put("c", C);

        String order = map.entrySet().stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .filter(n -> n.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining());

        int counter = map.values().stream()
                .filter(integer -> integer != 0)
                .min(Comparator.comparing(n -> n)).orElse(0);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < counter && order.length() > 1; i++) {
            result.append(order);
            A--;
            B--;
            C--;
        }

        fillWith('a', A, result);
        fillWith('b', B, result);
        fillWith('c', C, result);

        return result.toString();
    }

    private void fillWith(char x, int remaining, StringBuilder result) {
        if (result.length() == 0 && remaining > 0) {
            result.append(x);
            remaining--;
        }
        if (result.length() == 1 && remaining > 0) {
            result.append(x);
            remaining--;
        }
        for (int index = 0; index < result.length() - 1 && remaining > 0; index++) {
            if (index == 0 && result.charAt(index + 1) != x) {
                result.insert(index, x);
                remaining--;
            } else if (index == 1 && result.charAt(index + 1) != x && result.charAt(0) != x) {
                result.insert(index, x);
                remaining--;
            } else if (index > 1 && result.charAt(index) != x && (result.charAt(index - 1) != x || result.charAt(index - 2) != x)) {
                result.insert(index, x);
                remaining--;
            } else if (index > 0 && result.charAt(index) != x && result.charAt(index + 1) != x) {
                result.insert(index + 1, x);
                remaining--;
            } else if (result.charAt(result.length() - 1) != x) {
                result.append(x);
                remaining--;
            } else if (result.charAt(result.length() - 2) != x) {
                result.append(x);
                remaining--;
            }
        }
    }

}
