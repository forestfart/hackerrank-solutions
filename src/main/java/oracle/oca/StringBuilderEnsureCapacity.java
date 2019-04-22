package oracle.oca;

public class StringBuilderEnsureCapacity {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("12characters");
        System.out.println(sb.capacity()); // 12 + 16 = 28

        sb.ensureCapacity(28);
        System.out.println(sb.capacity()); // 28

        sb.ensureCapacity(22);
        System.out.println(sb.capacity()); // 28

        sb.ensureCapacity(29);
        System.out.println(sb.capacity()); // 58
    }
}
