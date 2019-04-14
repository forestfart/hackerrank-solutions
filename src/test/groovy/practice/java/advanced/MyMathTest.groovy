package practice.java.advanced

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MyMathTest extends Specification {

    @Shared
    MyMath myMath = new MyMath()

    @Unroll
    def 'test MyMath methods'(def performOperation, def num, def result) {
        expect:
        result == myMath.checker(performOperation, num)

        where:
        performOperation      | num      || result
        myMath.isOdd()        | 3        || true
        myMath.isOdd()        | 4444     || false
        myMath.isPrime()      | 52       || false
        myMath.isPrime()      | 13       || true
        myMath.isPalindrome() | 56456541 || false
        myMath.isPalindrome() | 123321   || true
    }

}
