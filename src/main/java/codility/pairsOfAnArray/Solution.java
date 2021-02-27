package codility.pairsOfAnArray;

public class Solution {

    public boolean solution(int[] A) {
        // write your code in Java SE 8

        for (int i = 0; i < A.length; i++) {
            boolean check = false;
            for (int x = 0; x < A.length; x++) {
                if (i == x) break;
                if (A[i] == A[x]) check = !check;
                if (x == A.length - 2 && !check) return false;
            }
        }
        return true;
    }

}
