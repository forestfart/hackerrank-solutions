package practice.algorithms.implementation.formingamagicsquare;


import java.util.Arrays;

public class Solution {

    public static int[] sumElements(int[][] s) {
        int[] sum = new int[8];
        for (int i = 0; i < 3; i++) {
            sum[0] += s[0][i];
            sum[1] += s[1][i];
            sum[2] += s[2][i];
            //sum[i] = s[i][0] + s[i][1] + s[i][2];
            sum[3] += s[i][0];
            sum[4] += s[i][1];
            sum[5] += s[i][2];
            //sum[i+3] = s[0][i] + s[1][i] + s[2][i];
            sum[6] += s[i][i];
            sum[7] += s[i][2-i];
        }
        return sum;
    }

    public static boolean checkIfMagicHappens(int[][] s) {
        int[] sum = sumElements(s);
        boolean isMagic = true;
        for (int i = 0; i < sum.length-1; i++) if (sum[i] != sum[i+1]) isMagic = false;
        return isMagic;
    }


    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        // best solution - get array of matching 15's sum and compare. Middle will always be the 5, and a corners will always be a even.
        int cost[] = {0, 0, 0, 0, 0, 0, 0, 0};
        int t[][] = {
            { 2, 9, 4, 7, 5, 3, 6, 1, 8 },
            { 2, 7, 6, 9, 5, 1, 4, 3, 8 },
            { 4, 9, 2, 3, 5, 7, 8, 1, 6 },
            { 4, 3, 8, 9, 5, 1, 2, 7, 6 },
            { 6, 7, 2, 1, 5, 9, 8, 3, 4 },
            { 6, 1, 8, 7, 5, 3, 2, 9, 4 },
            { 8, 1, 6, 3, 5, 7, 4, 9, 2 },
            { 8, 3, 4, 1, 5, 9, 6, 7, 2 },
        };

        for(int i = 0; i < 8; i++) {
            cost[i] = Math.abs(t[i][0]-s[0][0]) + Math.abs(t[i][1]-s[0][1]) + Math.abs(t[i][2]-s[0][2]);
            cost[i] = cost[i] + Math.abs(t[i][3]-s[1][0]) + Math.abs(t[i][4]-s[1][1]) + Math.abs(t[i][5]-s[1][2]);
            cost[i] = cost[i] + Math.abs(t[i][6]-s[2][0]) + Math.abs(t[i][7]-s[2][1]) + Math.abs(t[i][8]-s[2][2]);
        }
        int minCost = cost[0];
        for (int i = 1; i < cost.length; i++) if (minCost > cost[i]) minCost = cost[i];
        System.out.println(minCost);
        return minCost;
    }
}