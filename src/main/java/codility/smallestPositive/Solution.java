package codility.smallestPositive;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        for (int i = 1; i < 1000000; i++) {
            final int index = i;
            if (!Arrays.stream(A).anyMatch(n -> n == index)) {
                return i;
            }
        }
        return 1000000;
    }
}
