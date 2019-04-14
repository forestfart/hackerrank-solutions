import spock.lang.Specification
import spock.lang.Unroll

import static java.lang.Math.*

class TestSpock extends Specification {

    @Unroll
    def 'test power with unroll'(int a, int b, int c) {

        when:
        def calc = pow(a, b)

        then:
        calc == c

        where:
        a       | b   || c
        1.5     | 2.0 || 1.0
        2.0     | 2.0 || 4.0
        3.0     | 2.5 || 9.0
        112.0   | 4.0 || 1.57351936E8
    }

    @Unroll
    def 'numbers to the power'(int a, int b, int c) {
        expect:
        pow(a, b) == c

        where:
        a | b || c
        1 | 2 || 1
        2 | 2 || 4
        3 | 2 || 9
    }
}