package oracle.ocp.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamMaxFun {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 12, 14);
        System.out.println(list.stream().max(Comparator.comparing(a -> a)).get());
    }
}
