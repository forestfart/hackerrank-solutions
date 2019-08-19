package oracle.ocp.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ToArrayCheck {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(2,0,4,1);
        System.out.println(stream.skip(2).limit(1).toArray()[0]);
        System.out.println("---");
        Stream<Integer> stream2 = Stream.of(2,0,4,1);
        Object[] stream2Array = stream2.skip(1).limit(2).toArray();
        Arrays.stream(stream2Array).forEach(System.out::println);
    }

}
