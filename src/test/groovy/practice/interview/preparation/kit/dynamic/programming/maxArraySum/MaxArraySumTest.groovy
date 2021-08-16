package groovy.practice.interview.preparation.kit.dynamic.programming.maxArraySum

import practice.interview.preparation.kit.dynamic.programming.maxArraySum.MaxArraySum
import spock.lang.Specification

class MaxArraySumTest extends Specification {
    def 'testSolution'() {
        given:
        int[] inputArray = [3, 7, 4, 6, 5]

        when:
        def result = MaxArraySum.solve(inputArray)

        then:
        result == 13
    }

}
