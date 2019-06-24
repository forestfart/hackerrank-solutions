package oracle.ocp;

@FunctionalInterface
interface LambdaFunction {
    void call(String t);
}

@FunctionalInterface
interface StrangeInterfaceCheck {
    void tellMeArea(int a, int b);
}

public class Lambda {
    public static void main(String[] args) {
        LambdaFunction lambdaFunction = System.out::println;
        lambdaFunction.call("the Message");

        StrangeInterfaceCheck nice = (a, b) -> System.out.println(a * b);
        nice.tellMeArea(10,10);
    }
}
