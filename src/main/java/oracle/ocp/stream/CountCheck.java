package oracle.ocp.stream;

import java.util.Arrays;
import java.util.List;

public class CountCheck {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("", "jjj", "", "sdf", "SDf");
        Long count = list.stream()
                .filter(n -> !n.isEmpty())
                .count();
        System.out.println(count);
    }
}
