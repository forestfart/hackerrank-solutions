package practice.interview.preparation.kit.arrays.leftRotation

import spock.lang.Specification
import spock.lang.Unroll

class LeftRotationSolutionTest extends Specification {

    @Unroll
    def 'testInput'(int[] inputArray, int d, Object[] resultArray) {

        expect:
        Arrays.deepEquals(resultArray, LeftRotationSolution.rotLeft(inputArray, d))

        where:
        inputArray                                                                    | d  || resultArray
        [1, 2, 3, 4, 5]                                                               | 2  || [3, 4, 5, 1, 2]
        [41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51] | 10 || [77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77]
    }

}
