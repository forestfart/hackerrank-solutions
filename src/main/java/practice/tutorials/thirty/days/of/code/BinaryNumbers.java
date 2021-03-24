package practice.tutorials.thirty.days.of.code;

public class BinaryNumbers {
    public static int printConsequtives(int n) {
        String bin = Integer.toBinaryString(n);
        int max = 0, counter = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                counter++;
            } else {
                counter = 0;
            }
            if (max < counter) max = counter;
        }
        return max;
    }

}
