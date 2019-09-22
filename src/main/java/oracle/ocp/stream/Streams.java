package oracle.ocp.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
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

class StreamCheck4 {
    public static void main(String args[]) {
        Stream<String> list = Stream.of("ABC", "aBB", "AbCC", "ab", "acC");
        Map map = list.collect(Collectors.partitioningBy((String s) -> s.startsWith("ab")));
        System.out.println(map);
    }
}

class StreamCheck5 {
    public static void main(String[] args) {
        LongStream longStream = LongStream.range(30,60);
        LongPredicate longPredicate = l -> l%3==0;
        longStream.filter(longPredicate).forEach(System.out::println);
    }
}

class StreamCheck6 {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1,234,5,678,9,0,1,23,456);
        stream1.parallel().forEach(System.out::print);
        System.out.println("");
        Stream<Integer> stream2 = Stream.of(1,234,5,678,9,0,1,23,456);
        stream2.parallel().forEachOrdered(System.out::print);
    }
}
