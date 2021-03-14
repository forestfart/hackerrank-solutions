package practice.interview.preparation.kit.arrays.minimumSpawps2

import spock.lang.Specification
import spock.lang.Unroll

import static practice.interview.preparation.kit.arrays.minimumSpawps2.MinimumSwaps2Solution.minimumSwaps

class MinimumSwaps2SolutionTest extends Specification {

    @Unroll
    def 'testInput'(int[] inputArray, int result) {

        expect:
        result == minimumSwaps(inputArray)

        where:
        inputArray            || result
        [7, 1, 3, 2, 4, 5, 6] || 5
        [4, 3, 1, 2]          || 3
        [2, 3, 4, 1, 5]       || 3
    }

}
