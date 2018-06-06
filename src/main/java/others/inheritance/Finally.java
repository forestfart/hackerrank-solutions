package others.inheritance;

public class Finally {
    public static String testFinally() {
        try {
            // System.exit(0);
            return "will you execute the 'finally' block?";
        } finally {
            System.out.println("yes I did!");
        }
    }

    public static void main(String[] args) {
        String test = Finally.testFinally();
        System.out.println(test);
    }
}
