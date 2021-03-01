package codility.farthestDiagram

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "testSolution"(String example, int expected) {
        given:
        def sut = new FarthestDiagramSolution()

        expect:
        expected == sut.solution(example)

        where:
        example                                  || expected
        "aaa"                                    || 1
        "UDDDUDUUGGUU"                           || 4
        "DDUUDDUDUUUD"                           || 7
        "DDDUDDUUDUDUUUUDUDUDUUDUDUUUUDUUUUUUUU" || 30
        "aakmaakmakda"                           || 7
    }

}
