package practice.interview.preparation.kit.arrays.minimumSpawps2;

public class MinimumSwaps2Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0, temp, n, length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] != i + 1) {
                n = i;
                while (arr[n] != i + 1) {
                    n++;
                }
                temp = arr[i];
                arr[i] = arr[n];
                arr[n] = temp;
                swaps++;
            }
        }
        return swaps;
    }

}