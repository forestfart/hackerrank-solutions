package practice.algorithms.implementation.larrys.array

import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Paths

class SolutionTest extends Specification {

    @Unroll
    def 'Test Larrys Array solution'(def inputFile, def result) {
        given:
        def inputArray = load(inputFile)

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

    def load(inputFile) {
        def scanner = new Scanner(Paths.get("src\\test\\groovy\\practice\\algorithms\\implementation\\larrys\\array\\input", inputFile))
        def n = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        def a = new int[n]
        String[] AItems = scanner.nextLine().split(" ")
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (int i = 0; i < n; i++) {
            def AItem = Integer.parseInt(AItems[i])
            a[i] = AItem
        }
        scanner.close()
        return a
    }
}



