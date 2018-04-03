package codility.nonDecreasingOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public boolean solution(final int[] A) {
        int troubles = 0;
        List<Integer> copyA = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            copyA.add(A[i]);
        }
        Collections.sort(copyA);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != copyA.get(i)) {
                troubles++;
            }
        }
        if (troubles > 2) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[] { 1, 5 , 3, 3, 7 };
        System.out.println(solution.solution(array));
        array = new int[] { 1, 3, 5, 3, 4 };
        System.out.println(solution.solution(array));
    }
}
