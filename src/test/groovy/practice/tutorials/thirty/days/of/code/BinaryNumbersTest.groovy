package practice.tutorials.thirty.days.of.code

import spock.lang.Specification
import spock.lang.Unroll

import static practice.tutorials.thirty.days.of.code.BinaryNumbers.printConsequtives

class BinaryNumbersTest extends Specification {
    @Unroll
    def 'testInput'(int input, int result) {
        expect:
        result == printConsequtives(input)

        where:
        input || result
        439   || 3
    }
}
