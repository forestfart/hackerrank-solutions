package practice.interview.preparation.kit.arrays.newYearChaos

import spock.lang.Specification
import spock.lang.Unroll

class NewYearChaosSolutionTest extends Specification {

    @Unroll
    def 'testInput'(int[] input, String result) {
        expect:
        result == NewYearChaosSolution.minimumBribes(input)

        where:
        input                    || result
        [2, 1, 5, 3, 4]          || 3
        [2, 5, 1, 3, 4]          || 'Too chaotic'
        [5, 1, 2, 3, 7, 8, 6, 4] || 'Too chaotic'
        [1, 2, 5, 3, 7, 8, 6, 4] || 7
        [3, 4, 5, 6, 7, 8, 2, 1] || 13
        [3, 4, 5, 1, 6, 7, 8, 2] || 9
        [3, 4, 5, 2, 6, 7, 8, 1] || 10
    }
}
