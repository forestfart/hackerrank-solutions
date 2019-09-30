package oracle.ocp.clazz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

interface CourseFilter extends Predicate<String> {
    public default boolean test(String str) {
        return str.contains("Java");
    }
}

public class InterfaceInstance {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Java", "JavaEE", "JavaME");
        Predicate<String> courseFilter1 = s -> s.length() > 4;
        Predicate courseFilter2 = new CourseFilter() {
            public boolean test(String s) {
                return s.equals("Java");
            }
        };
        long c = stringList.stream()
                .filter(courseFilter1)
                .filter(courseFilter2)
                .count();
        System.out.println(c);
    }
}
