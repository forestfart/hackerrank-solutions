package oracle.ocp.functions;

import java.util.function.Function;

public class ComposeCheck {

    public static void main(String[] args) {
        Function<Double, Integer> getInt = d -> d.intValue();
        Function<Integer, String> getString = i -> i.toString();

        Function<Double, String> getComposed = getString.compose(getInt);

        System.out.println(getComposed.apply(13.34));
    }

}
