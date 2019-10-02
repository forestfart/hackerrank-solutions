package oracle.ocp.functions;

import java.util.function.ToIntFunction;

public class ToIntFunctionTest {
    public static void main(String[] args) {
        String string = "Java is the program lang";
        ToIntFunction<String> toIntFunction = s -> string.indexOf(s);
        System.out.println(toIntFunction.applyAsInt("lang"));
    }
}
