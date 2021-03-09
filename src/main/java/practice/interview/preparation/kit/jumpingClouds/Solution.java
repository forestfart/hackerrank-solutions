package practice.interview.preparation.kit.jumpingClouds;

public class Solution {
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        for (int index = 0; index < c.length - 1; index++, jumps++) {
            if (index < c.length - 2 && c[index + 2] == 0) index++;
        }
        return jumps;
    }

}
