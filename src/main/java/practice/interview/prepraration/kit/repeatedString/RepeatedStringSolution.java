package practice.interview.prepraration.kit.repeatedString;

public class RepeatedStringSolution {
    public static long repeatedString(String s, long n) {
        if (s.equals("")) return 0;

        int size = s.length();
        long manyTimes = n / (long) size;

        long counter = 0;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == 97) {
                counter++;
            }
        }

        counter = counter * manyTimes;

        long leftover = n % (long) size;
        for (int index = 0; index < leftover; index++) {
            if (s.charAt(index) == 97) {
                counter++;
            }
        }
        return counter;
    }

}
