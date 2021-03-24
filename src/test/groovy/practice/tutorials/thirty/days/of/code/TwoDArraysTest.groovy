package practice.tutorials.thirty.days.of.code

import spock.lang.Specification
import spock.lang.Unroll

import static practice.tutorials.thirty.days.of.code.TwoDArrays.hourGlass

class TwoDArraysTest extends Specification {
    @Unroll
    def 'test2dInput'(int result, int[][] inputArray) {
        expect:
        result == hourGlass(inputArray)

        where:
        result || inputArray
        7      || [[1, 1, 1, 0, 0, 0], [0, 1, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]
        19     || [[1, 1, 1, 0, 0, 0], [0, 1, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0], [0, 0, 2, 4, 4, 0], [0, 0, 0, 2, 0, 0], [0, 0, 1, 2, 4, 0]]
        -63    || [[-9, -9, -9, -9, -9, -9], [-9, -9, -9, -9, -9, -9], [-9, -9, -9, -9, -9, -9], [-9, -9, -9, -9, -9, -9], [-9, -9, -9, -9, -9, -9], [-9, -9, -9, -9, -9, -9]]

    }
}