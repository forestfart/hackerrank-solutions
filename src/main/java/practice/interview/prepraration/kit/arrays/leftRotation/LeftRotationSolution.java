package practice.interview.prepraration.kit.arrays.leftRotation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LeftRotationSolution {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] arr1 = Arrays.copyOfRange(a, 0, d);
        int[] arr2 = Arrays.copyOfRange(a, d, a.length);
        return IntStream.concat(Arrays.stream(arr2), Arrays.stream(arr1)).toArray();
    }

}
