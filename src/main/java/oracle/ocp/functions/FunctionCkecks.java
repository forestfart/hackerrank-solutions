package oracle.ocp.functions;

import java.util.function.Function;

public class FunctionCkecks {

    public static void main(String args[]) {
        Function<Integer, String> fun = s -> s.toString();
        Function<String, String> fun2 = fun.andThen((String s) -> s + "2")
                .compose((String s) -> Integer.parseInt(s));
    }

}
