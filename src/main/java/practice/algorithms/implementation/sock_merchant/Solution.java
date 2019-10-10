package practice.algorithms.implementation.sock_merchant

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    static int sockMerchant(int n, int... ar) {
        Map<Integer, Long> groupedList = Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return (int) groupedList.values().stream()
                .map(g -> g/2)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(3, new int[]{1, 1, 1, 5, 5, 5, 5, 5, 5, 2, 3, 3, 4, 5}));
    }
}
