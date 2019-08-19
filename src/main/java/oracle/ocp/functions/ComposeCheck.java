package oracle.ocp.functions;

import java.util.function.Function;

public class ComposeCheck {

    public strictfp static void main(String[] args) {
        Function<Float, Integer> getInt = f -> f.intValue();
        Function<Integer, String> getString = i -> i.toString();

        Function<Float, String> getComposed = getString.compose(getInt);

        System.out.println(getComposed.apply(13.34F));
    }

}
