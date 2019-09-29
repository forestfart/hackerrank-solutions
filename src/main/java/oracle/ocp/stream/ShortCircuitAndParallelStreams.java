package oracle.ocp.stream;

import java.util.Arrays;
import java.util.List;

public class ShortCircuitAndParallelStreams {
    public static void main(String[] args) {
        List<String> cs = Arrays.asList("Java", "Java SE", "Java ME");

        System.out.println(cs.stream().findAny().get().equals("Java"));
        System.out.println(cs.stream().anyMatch(w -> w.equals("Java")));
        System.out.println(cs.stream().findFirst().get().equals("Java"));
        System.out.println(cs.stream().allMatch(w -> w.equals("Java")));

        Long count = cs.stream().filter(n -> !n.equals("Java")).count();
        System.out.println(count);
    }
}
