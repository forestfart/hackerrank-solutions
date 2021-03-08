package practice.interview.prepraration.kit.sorting

import oracle.ocp.stream.StreamDataMethods
import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Paths

class FraudlentActivityNotificationTest extends Specification {

    @Unroll
    def 'testInput'(int trailingDays, int[] input, int result) {

        expect:
        result == FraudlentActivityNotification.activityNotifications(input, trailingDays)

        where:
        trailingDays | input                       || result
        5            | [2, 3, 4, 2, 3, 6, 8, 4, 5] || 2
        4            | [1, 2, 3, 4, 4]             || 0
        3            | [10, 20, 30, 40, 50]        || 1
        4            | [1, 2, 3, 4, 5]             || 1
    }

    @Unroll
    def 'testFaster'(int trailingDays, int[] input, int result) {

        expect:
        result == FraudlentActivityNotificationFaster.activityNotifications(input, trailingDays)

        where:
        trailingDays | input                       || result
        5            | [2, 3, 4, 2, 3, 6, 8, 4, 5] || 2
        4            | [1, 2, 3, 4, 4]             || 0
        3            | [10, 20, 30, 40, 50]        || 1
        4            | [1, 2, 3, 4, 5]             || 1
    }

    def 'testInput1'() {
        given:
        File file = new File("src/test/groovy/practice/interview/prepraration/kit/sorting/input1")


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
