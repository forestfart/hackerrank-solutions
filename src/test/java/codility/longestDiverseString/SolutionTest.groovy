package codility.longestDiverseString

import spock.lang.Specification

class SolutionTest extends Specification {

    def 'testReturnValue'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(6, 1, 1)

        then:
        result.length() == 8
        result.equals("aabaacaa")
    }

    def 'testReturnValue2'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(8, 4, 2)

        then:
        result.length() == 14
        result.equals("bababaacaabcaa")
    }

    def 'testReturnValue3'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(1, 4, 2)

        then:
        result.length() == 7
        result.equals("cbbcbab")
    }

    def 'testReturnValue4'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(1, 4, 8)

        then:
        result.length() == 13
        result.equals("ccbccbccabbcc")
    }

    def 'testReturnValue5'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(0, 4, 8)

        then:
        result.length() == 12
        result.equals("ccbccbcbcbcc")
    }

    def 'testReturnValue6'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(1, 4, 0)

        then:
        result.length() == 5
        result.equals("bbabb")
    }

    def 'testReturnValue7'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(15, 40, 0)

        then:
        result.length() == 47
        result.equals("bbabbabbabbabbabbabbabbabbabbabbabbabbabbabbabb")
    }

    def 'testReturnValue8'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(0, 0, 1)

        then:
        result.length() == 1
        result.equals("c")
    }

    def 'testReturnValue9'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(2, 0, 0)

        then:
        result.length() == 2
        result.equals("aa")
    }

    def 'testReturnValue10'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(0, 20, 0)

        then:
        result.length() == 2
        result.equals("bb")
    }

    def 'testReturnValue11'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(0, 20, 1)

        then:
        result.length() == 5
        result.equals("bbcbb")
    }

    def 'testReturnValue12'() {
        given:
        Solution solution = new Solution()

        when:
        String result = solution.solution(0, 0, 0)

        then:
        result.length() == 0
        result.equals("")
    }

}
