package practice.algorithms.implementation.sock_merchant

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    static int sockMerchant(int n, int... ar) {
        Map<Integer, List<Integer>> groupedList = Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(ni -> ni));
        return groupedList.values().stream()
                .map(List::size)
                .map(g -> g/2)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(3, new int[]{1, 1, 1, 5, 5, 5, 5, 5, 5, 2, 3, 3, 4, 5}));
    }
}
