package codility.disjoinIntervals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private Integer[] checkPair(Integer ai, Integer bi, Integer aj, Integer bj) {
        if (ai <= aj && bi >= aj) {                         // overlap right
            if (bi >= bj) {
                return new Integer[]{ai, bi};
            }
            return new Integer[]{ai, bj};
        }
        if (ai >= aj && ai <= bj) {                         // overlap left
            if (bi >= bj) {
                return new Integer[]{aj, bi};
            }
            return new Integer[]{aj, bj};
        }
        return null;
    }

    public int solution(int[] a, int[] b) {
        Integer[] result;
        List<Integer> aList = IntStream.of(a).boxed().collect(Collectors.toList());
        List<Integer> bList = IntStream.of(b).boxed().collect(Collectors.toList());
        for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < aList.size(); j++) {
                if (i != j && i < aList.size() && j < bList.size()) {
                    result = checkPair(aList.get(i), bList.get(i), aList.get(j), bList.get(j));
                    if (result != null) {
                        System.out.println(i + ":" + j + " replacing " + aList.set(i, result[0]) + " with " + result[0]);
                        System.out.println(i + ":" + j + " replacing " + bList.set(i, result[1]) + " with " + result[1]);
                        System.out.println(+i + ":" + j + " removing: " + aList.remove(j));
                        System.out.println(+i + ":" + j + " removing: " + bList.remove(j));
                        i = 0; j = 0;
                    }
                }
            }

        }
        System.out.println(aList + "\n" + bList);
        return 0;
    }

    public static void main(String[] args) {
        Solution run = new Solution();
        int[] a = new int[]{5, 1, 49, 80, 10};
        int[] b = new int[]{18, 20, 50, 89, 200};

        int[] x = new int[]{5, 1, 49, 80, 10, 34, 3, -100, -23, 23, 80};
        int[] y = new int[]{18, 15, 50, 89, 20, 47, 4, -86, -1, 34, 120};

        int[] c = new int[]{1, 12, 42, 70, 36, -4, 43};
        int[] d = new int[]{5, 15, 44, 72, 36, 2, 69};

        int[] e = new int[]{-1_000_000_000};
        int[] f = new int[]{1_000_000_001};

        run.solution(a, b);
        System.out.println("\n------");
        run.solution(x, y);
        System.out.println("\n------");
        run.solution(c, d);
        System.out.println("\n------");
        run.solution(e, f);
    }
}
