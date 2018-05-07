package codility.maxAsceedingSlice;

public class Solution {
    public int solution(int[] input) {
        // write your code in Java SE 8
        int asceedingStart = 0;
        int asceedingCounter = 1;
        int maxAsceeding = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i-1] >= input[i]) {
                asceedingStart = i;
            }
            if ((i - asceedingStart) + 1 > asceedingCounter) {
                maxAsceeding = asceedingStart;
                asceedingCounter = (i - asceedingStart) + 1;
            }
        }
        return maxAsceeding;
    }
}