package codility.pairsOfAnArray

import spock.lang.Specification

class SolutionTest extends Specification {

    def 'testReturnValue'() {
        given:
        Solution solution = new Solution();
        int[] a = [1,2,2,1]

        when:
        boolean result = solution.solution(a)

        then:
        result == true
    }

    def 'testReturnValue1'() {
        given:
        Solution solution = new Solution();
        int[] a = [1,2,2,3]

        when:
        boolean result = solution.solution(a)

        then:
        result == false
    }

    def 'testReturnValue2'() {
        given:
        Solution solution = new Solution();
        int[] a = [7,7,7]

        when:
        boolean result = solution.solution(a)

        then:
        result == false
    }
}
