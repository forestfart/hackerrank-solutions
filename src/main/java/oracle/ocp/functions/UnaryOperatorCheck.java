package oracle.ocp.functions;

import java.util.function.UnaryOperator;

public class UnaryOperatorCheck {
    public static void main(String[] args) {
        String str1 = "Java";
        StringBuffer stringBuffer = new StringBuffer("Course");
        UnaryOperator<String> u = (str2) -> str1.concat(str2);
        UnaryOperator<String> l = str3 -> str3.toLowerCase();
        System.out.println(u.apply(l.apply("stringBuffer")));
    }
}
