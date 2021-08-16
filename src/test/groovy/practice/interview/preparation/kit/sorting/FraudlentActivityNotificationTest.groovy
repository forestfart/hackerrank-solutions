package groovy.practice.interview.preparation.kit.sorting

import spock.lang.Specification
import spock.lang.Unroll

import java.time.Duration
import java.time.Instant

import static groovy.tools.InputFileReader.loadThreeDataInput

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

    @Unroll
    def 'testFastest'(int trailingDays, int[] input, int result) {

        expect:
        result == FraudlentActivityNotificationFastest.activityNotifications(input, trailingDays)

        where:
        trailingDays | input                       || result
        5            | [2, 3, 4, 2, 3, 6, 8, 4, 5] || 2
        4            | [1, 2, 3, 4, 4]             || 0
        3            | [10, 20, 30, 40, 50]        || 1
        4            | [1, 2, 3, 4, 5]             || 1
    }

    @Unroll
    def 'testLargeInput'(String inputFile, int result) {
        given:
        def path = "src\\test\\groovy\\practice\\interview\\preparation\\kit\\sorting\\input"
        List<int[]> input = loadThreeDataInput(path, inputFile)

        expect:
        Instant start = Instant.now()
        result == FraudlentActivityNotificationFastest.activityNotifications((int[]) input.get(1), ((int[]) input.get(0))[1])
        println 'Fastest elapsed: ' + Duration.between(start, Instant.now()).toMillis() + 'ms'

        Instant start1 = Instant.now()
        result == FraudlentActivityNotificationFaster.activityNotifications((int[]) input.get(1), ((int[]) input.get(0))[1])
        println 'Faster elapsed: ' + Duration.between(start1, Instant.now()).toMillis() + 'ms'

        Instant start2 = Instant.now()
        result == FraudlentActivityNotification.activityNotifications((int[]) input.get(1), ((int[]) input.get(0))[1])
        println 'Slow elapsed: ' + Duration.between(start2, Instant.now()).toMillis() + 'ms'

        where:
        inputFile   || result
        'input.txt' || 633
    }

}
