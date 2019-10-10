package practice.algorithms.implementation.sock_merchant

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    static int sockMerchantPrimitive(int n, int... ar) {
        Set<Integer> colors = new HashSet<>();
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (!colors.contains(ar[i])) {
                colors.add(ar[i]);
            } else {
                pairs++;
                colors.remove(ar[i]);
            }
        }
        return pairs;
    }
    static int sockMerchantStream(int n, int... ar) {
        Map<Integer, List<Integer>> groupedList = Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(i -> i));
        return groupedList.values().stream()
                .map(List::size)
                .map(g -> g/2)
                .reduce(Integer::sum)
                .orElse(0);
    }
    static int sockMerchantStreamImproved(int n, int... ar) {
        Map<Integer, Long> groupedList = Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return groupedList.values().stream()
                .map(g -> g/2)
                .reduce(Long::sum).get().intValue();
    }

    public static void main(String[] args) {
        int size = 10_000_000;

        int[] intsArray = getIntsArray(size);
       // System.out.println(Arrays.toString(intsArray));

        long start = Instant.now().toEpochMilli();
        System.out.println(sockMerchantPrimitive(size, intsArray));
        System.out.println("Primitives elapse time: " + (Instant.now().toEpochMilli() - start + "ms"));

        start = Instant.now().toEpochMilli();
        System.out.println(sockMerchantStream(size, intsArray));
        System.out.println("Stream elapse time: " + (Instant.now().toEpochMilli() - start) + "ms");

        start = Instant.now().toEpochMilli();
        System.out.println(sockMerchantStreamImproved(size, intsArray));
        System.out.println("Stream elapse time: " + (Instant.now().toEpochMilli() - start) + "ms");
    }

    private static int[] getIntsArray(int size) {
        return new SplittableRandom().ints(size, 0, 10).parallel().toArray();
    }
}
