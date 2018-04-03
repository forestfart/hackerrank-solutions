package codility.maxVal;

import java.util.Random;

public class Solution {
    int solution(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 1;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (count[A[i]] > 0) {
                int tmp = count[A[i]] + 1;
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
                count[A[i]] = tmp +1;
            } else {
                count[A[i]] = 1;
            }
        }
        return A[index];
    }

    public static void main (String args[]) {
        Solution solution = new Solution();
        Random random = new Random();
        int[] array = new int[8];
        for (int i=0; i < 8; i++) {
            array[i]=random.nextInt(8);
            System.out.print(array[i] + " | " );
        }
        System.out.println("\n" + solution.solution(8, array));
    }
}
