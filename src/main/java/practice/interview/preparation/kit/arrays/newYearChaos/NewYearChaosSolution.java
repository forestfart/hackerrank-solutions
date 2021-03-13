package practice.interview.preparation.kit.arrays.newYearChaos;

import java.util.stream.IntStream;

public class NewYearChaosSolution {

    // Complete the minimumBribes function below.
    static String minimumBribes(int[] q) {
        int size = q.length;
        int bribes = 0;
        int tmp;
        int[] trace = IntStream.range(1, size + 1).toArray();
        for (int i = 0; i < size && bribes >= 0; i++) {
            if (q[i] == trace[i]) {
            } else if (i < size - 1 && q[i] == trace[i + 1]) {
                tmp = trace[i];
                trace[i] = trace[i + 1];
                trace[i + 1] = tmp;
                bribes++;
            } else if (i < size - 2 && q[i] == trace[i + 2]) {
                tmp = trace[i];
                trace[i] = trace[i + 2];
                trace[i + 2] = trace[i + 1];
                trace[i + 1] = tmp;
                bribes = bribes + 2;
            } else if (q[i] > i + 3) bribes = -1;
        }
        if (bribes == -1) return "Too chaotic";
        return String.valueOf(bribes);
    }


}
