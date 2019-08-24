package oracle.ocp.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByConcurrentTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        ConcurrentMap<Integer, List<Integer>> map = list.parallelStream().collect(Collectors.groupingByConcurrent(i -> i%2 == 0 ? 0 : 1));
        System.out.println(map.get(0));

        Stream<String> strs = Stream.of("2", "3", "4");
        System.out.println(strs.reduce("1", String::concat, String::concat));
    }

}
