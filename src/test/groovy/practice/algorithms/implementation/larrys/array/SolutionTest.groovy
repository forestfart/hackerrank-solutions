package practice.algorithms.implementation.larrys.array

import spock.lang.Specification
import spock.lang.Unroll

import static tools.InputFileReader.loadTwoDataInput

class SolutionTest extends Specification {

    @Unroll
    def 'Test Larrys Array solution'(def inputFile, def result) {
        given:
        def path = "src\\test\\groovy\\practice\\algorithms\\implementation\\larrys\\array\\input"
        def inputArray = loadTwoDataInput(path, inputFile)

        expect:
        result == Solution.larrysArrayAnswer(inputArray)
        println(inputArray)

        where:
        inputFile              || result
        'firstInput.txt'       || 'YES'
        'secondInput.txt'      || 'YES'
        'thirdInput.txt'       || 'NO'
        'mediumInput.txt'      || 'YES'
        'mediumNotPassing.txt' || 'NO'
        'largeInput.txt'       || 'YES'
        'custom.txt'           || 'NO'
    }

}



