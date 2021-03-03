package practice.interview.prepraration.kit.repeatedString

import spock.lang.Specification
import spock.lang.Unroll

import static RepeatedStringSolution.repeatedString

class RepeatedStringSolutionTest extends Specification {

    @Unroll
    def "testSolution"(String s, long length, long result) {
        expect:
        result == repeatedString(s, length)

        where:
        s     | length        || result
        'abc' | 10            || 4
        'a'   | 18884545      || 18884545
        ''    | 10            || 0
        'fg'  | 10            || 0
        'ab'  | 1000000000000 || 500000000000
    }

}