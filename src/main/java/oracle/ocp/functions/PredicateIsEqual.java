package oracle.ocp.functions;

import java.util.function.Predicate;

public class PredicateIsEqual {

    public static void main(String[] args) {
        String in = "1";
        Predicate<String> ins = Predicate.isEqual(in);
        System.out.println(ins.test("2"));
    }

}
