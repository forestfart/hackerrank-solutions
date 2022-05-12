package codility.binaryGap;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.

// System.out.println("this is a debug message");



class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String nStr = Integer.toBinaryString(N);
        int counter = 0;
        int maxCounter = 0;
        for (int i=0; i < nStr.length(); i++) {
            if (nStr.substring(i, i+1).equals("0")) {
                counter++;
                if (counter > maxCounter) {
                    maxCounter = counter;
                }
            } else {
                counter = 0;
            }
        }
        return maxCounter;
    }

    public static void main (String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1041));
    }
}
