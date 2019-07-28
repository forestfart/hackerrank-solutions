package oracle.ocp.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("a");
        lst.add("ab");
        lst.stream().forEach((s) -> System.out.println(s));
        lst.stream().forEach(System.out::println);
        lst.stream().forEach((k) -> k.length());
    }
}

class Streams2 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(4, 40, 8, 3);
        System.out.println(stream.peek(System.out::print).anyMatch(x -> x > 10));
    }
}

class Streams3 {
    public static void main(String[] args) {
        Stream list = Stream.of("ABC", "aBB", "AbCC", "ab", "acC");
        Object map = list.collect(Collectors.partitioningBy((String s) -> s.startsWith("ab")));
        System.out.println(map);
    }



}
