package oracle.ocp.collections;

import java.util.ArrayDeque;

public class ArrayDequeTest {

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(10);
        arrayDeque.add(20);
        arrayDeque.add(30);
        arrayDeque.add(40);
        System.out.println(arrayDeque.element() + arrayDeque.poll());
        arrayDeque.add(50);

        System.out.printf("First element: %d, last element: %d", arrayDeque.peekFirst(), arrayDeque.peekLast());
        System.out.println(arrayDeque);
    }

}
