package practice.interview.preparation.kit.string.manipulation;

public class AlternatingCharactersSolution {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int count = 0;
        for (int  i=1; i < s.length(); i++) {
            int n = i;
            while (n < s.length() && s.charAt(i - 1) == s.charAt(n)) {
                count++;
                n++;
            }
            i = n;
        }
        return count;
    }
}
