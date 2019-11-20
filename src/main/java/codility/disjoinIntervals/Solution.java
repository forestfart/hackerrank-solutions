package codility.disjoinIntervals;

import java.util.stream.IntStream;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
    int[] a_;
    int[] b_;

    public int solution(int[] a, int[] b) {
        a_ = a;
        b_ = b;
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    int[] result = checkPair(a_[i], b_[i], a_[j], b_[j]);
                    if (result.length == 2) {
                        join(result, Math.min(i, j), Math.max(i, j), a_, b_);
                        length = length - 1;
                        i = 0;
                        j = 0;
                    }
                }
            }
        }
        IntStream.of(a_).forEach(n -> System.out.print(n + ", "));
        System.out.print("\n");
        IntStream.of(b_).forEach(n -> System.out.print(n + ", "));
        return a_.length;
    }

    private void join(int[] result, int i, int j, int[] a, int[] b) {
        a_ = new int[a.length - 1];
        b_ = new int[b.length - 1];
        for (int index = 0; index < a_.length; index++) {
            if (index >= j) {
                a_[index] = a[index + 1];
                b_[index] = b[index + 1];
            } else if (index != i) {
                a_[index] = a[index];
                b_[index] = b[index];
            } else {
                a_[index] = result[0];
                b_[index] = result[1];
            }
        }
    }

    private int[] checkPair(int a1, int b1, int a2, int b2) {
        if (a2 <= a1 && b2 >= a1) {
            if (b1 >= b2) {
                return new int[]{a2, b1};               // overlap
            }
            return new int[]{a2, b2};
        }
        if (a2 >= a1 && a2 <= b1) {
            if (b2 >= b1) {
                return new int[]{a1, b2};               // overlap
            }
            return new int[]{a1, b2};
        }
        if (a2 <= a1 && b2 >= b1) {
            return new int[]{a2, b2};               // right includes left
        }
        if (a2 >= a1 && b2 <= b1) {
            return new int[]{a1, b1};               // left includes right
        } else {
            return new int[]{};
        }
    }


    public static void main(String[] args) {
        Solution run = new Solution();
        int[] a = new int[]{1, 5, 49, 80, 10};
        int[] b = new int[]{2, 45, 50, 99, 200};

        int[] c = new int[]{1, 12, 42, 70, 36, -4, 43};
        int[] d = new int[]{5, 15, 44, 72, 36, 2, 69};

        int[] e = new int[]{-1_000_000_000};
        int[] f = new int[]{1_000_000_001};

        run.solution(a, b);
        System.out.println("\n------");
        run.solution(c, d);
        System.out.println("\n------");
        run.solution(e, f);
    }
}
