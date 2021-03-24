package practice.tutorials.thirty.days.of.code;

public class TwoDArrays {
    public static int hourGlass(int[][] arr) {
        int max = -63, sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = sum(arr, i, j);
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    private static int sum(int[][] arr, int i, int j) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
    }

}
