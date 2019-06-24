package oracle.ocp;

@FunctionalInterface
interface LambdaFunction {
    void call(String t);
}

public class Lambda {
    public static void main(String[] args) {
        LambdaFunction lambdaFunction = System.out::println;
        lambdaFunction.call("the Message");
    }
}
