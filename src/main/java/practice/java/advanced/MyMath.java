package practice.java.advanced;

public class MyMath {
    boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    PerformOperation isPrime() {
        return (int a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
    }

    PerformOperation isPalindrome() {
        return (int a) -> Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
    }

}