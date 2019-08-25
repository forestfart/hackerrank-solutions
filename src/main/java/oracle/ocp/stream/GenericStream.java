package oracle.ocp.stream;

import java.util.stream.Stream;

public class GenericStream {
    public static void main(String[] args) {
        Stream stream = Stream.of(1,2,"s");
        boolean out = stream.allMatch(in -> in instanceof Number);
        System.out.println(out);
    }

}
