package oracle.ocp.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;

public class DoubleFunctionFun {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList (100.12, 200.32);
        DoubleFunction funD = d -> d + 100.0;
        doubles.stream().forEach(e -> System.out.println(funD.apply(e)));
        doubles.stream().forEach(e -> System.out.println(e));
    }
}