package practice.interview.preparation.kit.string.manipulation;

public class AlternatingCharactersSolution {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int count = 0, n, length = s.length();
        for (int i = 1; i < length; i++) {
            n = i;
            while (n < length && s.charAt(i - 1) == s.charAt(n)) {
                count++;
                n++;
            }
            i = n;
        }
        return count;
    }
}
