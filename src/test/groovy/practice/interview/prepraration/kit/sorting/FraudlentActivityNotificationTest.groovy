package practice.interview.prepraration.kit.sorting

import spock.lang.Specification
import spock.lang.Unroll

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

}
