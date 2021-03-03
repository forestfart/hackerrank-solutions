package practice.interview.prepraration.kit.stackandqueues

import spock.lang.Specification

class ATaleOfTwoStacksTest extends Specification {

    def "testEnqueueElements"() {
        when:
        MyQueue<Integer> myQueue = new MyQueue<>()
        myQueue.enqueue(35)

        then:
        myQueue.peek() == 35
    }

    def "testDequeueElements"() {
        given:
        MyQueue<Integer> myQueue = new MyQueue<>()
        myQueue.enqueue(35)

        when:
        Integer value = myQueue.dequeue()

        then:
        value == 35
    }

    def "testDequeueWith2Elements"() {
        given:
        MyQueue<Integer> myQueue = new MyQueue<>()
        MyQueue element1 = myQueue.enqueue(15)
        MyQueue element2 = element1.enqueue(55)

        when:
        Integer value = myQueue.dequeue()
        Integer value1 = myQueue.dequeue()

        then:
        value == 15
        value1 == 55
    }

    def "testDequeueWithSomeElements"() {
        given:
        MyQueue<Integer> myQueue = new MyQueue<>()
        MyQueue element1 = myQueue.enqueue(15)
        MyQueue element2 = element1.enqueue(55)
        MyQueue element3 = element2.enqueue(5)

        when:
        Integer value = myQueue.dequeue()
        Integer value1 = myQueue.dequeue()
        Integer value2 = myQueue.dequeue()

        then:
        value == 15
        value1 == 55
        value2 == 5

    }

    def "testPeekWithSomeElements"() {
        given:
        MyQueue<Integer> myQueue = new MyQueue<>()
        myQueue.enqueue(35)
        myQueue.enqueue(15)
        myQueue.enqueue(5)

        when:
        def result = myQueue.peek()

        then:
        result == 35
    }

    def "exampleFromHackerrankPeek"() {
        when:
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(42)
        myQueue.dequeue()
        myQueue.enqueue(14)
        def result1 = myQueue.peek()
        myQueue.enqueue(28)
        def result2 = myQueue.peek()
        myQueue.enqueue(60)
        myQueue.enqueue(78)
        myQueue.dequeue()
        myQueue.dequeue()

        then:
        result1 == 14
        result2 == 14
    }

}
