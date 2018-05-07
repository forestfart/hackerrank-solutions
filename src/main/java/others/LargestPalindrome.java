package others;

import java.util.ArrayList;
import java.util.List;

public class LargestPalindrome {

    public static boolean isPalindrome(long n) {
        String str = String.valueOf(n);
        int z = str.length();
        for (int i = 0; i < z/2; i++)
            if (str.charAt(i) != str.charAt(z-i-1)) return false;
        return true;
    }

    private static boolean isPrimeNumber(long n) {
        if (n < 2 || n == 4) return false;
        if (n < 4) return true;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        long iPalindrome = 0, jPalindrome = 0, foundPalindrome = 0;
        List<Long> primeNumbers = new ArrayList<>();
        for (long i = 10000; i < 99999; i++) if(isPrimeNumber(i)) primeNumbers.add(i);
        System.out.printf("%d prime numbers found\n", primeNumbers.size());

        for (long i : primeNumbers) {
            for (long j : primeNumbers) {
                long equalsMultiply = i * j;
                if (isPalindrome(equalsMultiply) && (equalsMultiply > foundPalindrome)) {
                    iPalindrome = i;
                    jPalindrome = j;
                    foundPalindrome = equalsMultiply;
                }
            }
        }
        System.out.printf("The highest palindrome recipe: %d * %d = %d", iPalindrome, jPalindrome, foundPalindrome);
        long endMillis = System.currentTimeMillis();
        System.out.printf("\nElapsed time: %d ms", endMillis - startMillis);
    }
}
