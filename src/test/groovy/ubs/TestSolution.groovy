package groovy.ubs

import spock.lang.Specification
import spock.lang.Unroll

import static java.lang.Math.pow
import static ubs.Solution.solve

class TestSolution extends Specification {
    def 'test'() {
        given:
        int[] testArray = [3, 7, 4, 6, 5]
        when:
        int sol = solve(5, testArray)
        then:
        println('dsf')
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
