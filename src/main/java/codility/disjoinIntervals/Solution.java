package codility.disjoinIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {

    public int solution(int[] a, int[] b) {
        Integer[] result;
        List<Integer> aList = IntStream.of(a).boxed().collect(Collectors.toList());
        List<Integer> bList = IntStream.of(b).boxed().collect(Collectors.toList());
        for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < aList.size(); j++) {
                if (i != j && i < aList.size() && j < bList.size()) {
                    result = checkPair(aList.get(i), bList.get(i), bList.get(j), bList.get(j));
                    if (result.length == 2) {
                        System.out.println(i + ":" + j + " replacing " + aList.set(i, result[0]) + " with " + result[0]);
                        System.out.println(i + ":" + j + " replacing " + bList.set(i, result[1]) + " with " + result[1]);
                        System.out.println(+ i + ":" + j + " removing: " + aList.remove(j));
                        System.out.println(+ i + ":" + j + " removing: " + bList.remove(j));
                    }
                }
            }
        }
        System.out.println(aList + "\n" + bList);

        return 0;
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

    private Integer[] checkPair(Integer a1, Integer b1, Integer a2, Integer b2) {
        if (a2 <= a1 && b2 >= a1) {
            if (b1 >= b2) {
                return new Integer[]{a2, b1};               // overlap
            }
            return new Integer[]{a2, b2};
        }
        if (a2 >= a1 && a2 <= b1) {
            if (b2 >= b1) {
                return new Integer[]{a1, b2};               // overlap
            }
            return new Integer[]{a1, b2};
        }/*
        if (a2 <= a1 && b2 >= b1) {
            return new int[]{a2, b2};               // right includes left
        }
        if (a2 >= a1 && b2 <= b1) {
            return new int[]{a1, b1};               // left includes right
        */ else {
            return new Integer[]{};
        }
    }
}
