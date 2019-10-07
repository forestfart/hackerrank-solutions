package oracle.ocp.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
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

class StreamCheck7 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30);
        Function<Integer, Integer> function = element -> element + element;
        Consumer<Integer> consumer = s -> System.out.printf("val:%s ", s);
        list.stream().map(function).forEach(consumer);
    }
}

class StreamCheck8 {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Mike", 30),
                new Person("Mike Hill", 21),
                new Person("Thomas Hill", 24));
        Stream<Person> stream = personList.stream().filter(p -> p.getAge() > 22);
        System.out.println(stream.filter(p -> p.getName().contains("Hill")).count());
    }
}

class Done {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("win most", "try best ", "best choice", "done");

        Predicate<String> test1 = s -> {
            System.out.println("Checking...");
            return s.equals("done");
        };

        Predicate<String> test2 = (String s) -> s.length() > 4;

        list.stream()
                .filter(test1)
                .filter(test2)
                .count();
    }
}

class ConsumerTest {
    public static void main(String[] args) {
        List<Person> productList = Arrays.asList(new Person("PlasticShit", 100), new Person("NonPlasticShit", 400));
        Consumer<Person> consumer = n -> n.setAge(n.getAge() + 10);
        productList.forEach(consumer);
        productList.forEach(System.out::println);
    }
}

class Person {
    String name;
    Integer age;
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ':' + age;
    }
}