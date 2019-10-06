package oracle.ocp.collections;

import java.util.ArrayDeque;

public class ArrayDequeTest {

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(10);
        arrayDeque.add(20);
        arrayDeque.add(30);
        arrayDeque.add(40);
        arrayDeque.add(50);
        System.out.println(arrayDeque);
        System.out.printf("First element: %d, last element: %d\n", arrayDeque.peekFirst(), arrayDeque.peekLast());
        System.out.println("Element: " + arrayDeque.element() + " polling: " + arrayDeque.poll());
        System.out.println("now contains: " + arrayDeque);
        System.out.println("Popping element: " + arrayDeque.pop());
        System.out.println("now contains: " + arrayDeque);
        System.out.println("Removing element: " + arrayDeque.remove());
        System.out.println("now contains: " + arrayDeque);
        System.out.println("Removing first element: " + arrayDeque.removeFirst());
        System.out.println("now contains: " + arrayDeque);
        arrayDeque.offer(200);
        arrayDeque.push(203);
        System.out.println("peeks: " + arrayDeque.peek());
        System.out.println("now contains: " + arrayDeque);
    }
}

class PushPopRemove {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(10);
        arrayDeque.push(20);
        arrayDeque.add(20);
        arrayDeque.push(40);
        int i1 = arrayDeque.remove();
        int i2 = arrayDeque.pop();
        System.out.println(i1 + " " + i2);
    }
}
