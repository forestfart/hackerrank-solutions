package codility.smallestPositive

import spock.lang.Specification

class SolutionTest extends Specification {

    def 'testReturnValue'() {
        given:
        Solution solution = new Solution();
        int[] a = [1,2,3]

        when:
        int result = solution.solution(a)

        then:
        result == 4
    }

}
