package practice.interview.preparation.kit.jumpingClouds

import spock.lang.Specification
import spock.lang.Unroll

import static Solution.jumpingOnClouds

class SolutionTest extends Specification {

    @Unroll
    def "testSolution"(int[] example, int expected) {
        expect:
        expected == jumpingOnClouds(example)

        where:
        example                     || expected
        [0, 0, 0, 0, 1, 0]          || 3
        [0, 0, 1, 0, 0, 1, 0]       || 4
        [0, 0, 0, 1, 0, 0]          || 3
        [0, 1, 0, 0, 0, 1, 0]       || 3
        [0, 1, 0, 0, 1, 0, 0, 0, 0] || 5
        [0]                         || 0
        [0, 0]                      || 1
    }

}
