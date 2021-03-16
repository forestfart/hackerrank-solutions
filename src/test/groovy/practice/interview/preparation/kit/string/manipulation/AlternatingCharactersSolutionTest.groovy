package practice.interview.preparation.kit.string.manipulation

import spock.lang.Specification
import spock.lang.Unroll

import static practice.interview.preparation.kit.string.manipulation.AlternatingCharactersSolution.alternatingCharacters

class AlternatingCharactersSolutionTest extends Specification {

    @Unroll
    def 'testInput'() {
        expect:
        result == alternatingCharacters(input)

        where:
        input        || result
        'AAAA'       || 3
        'ABABAB'     || 0
        'AAASKLDDDA' || 4
    }
}
