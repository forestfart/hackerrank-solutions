package practice.algorithms.implementation.larrys.array;

public class Solution {

    static String larrysArrayAnswer(int[] a) {
        int inversionCount = 0;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i + 1; j < a.length; j++)
            if (a[i] > a[j]) inversionCount++;
        }
        return inversionCount % 2 == 0 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(Solution.larrysArrayAnswer(new int[]{3, 1, 2}));
        System.out.println(Solution.larrysArrayAnswer(new int[]{4, 1, 3, 2}));
        System.out.println(Solution.larrysArrayAnswer(new int[]{1, 2, 3, 5, 4}));
    }
}
