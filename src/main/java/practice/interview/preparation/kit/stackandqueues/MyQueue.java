package practice.interview.preparation.kit.stackandqueues;

public class MyQueue<T> {
    private final Element<T> back;
    private final Element<T> front;
    private MyQueue<T> nextElement;
    private MyQueue<T> previousElement;
    private T value;

    public MyQueue() {
        this.back = new Element<T>(this);
        this.front = new Element<T>(this);
    }

    private MyQueue(T value, Element<T> back, Element<T> front) {
        this.value = value;
        this.front = front;
        this.back = back;
    }

    public MyQueue<T> enqueue(T value) {
        if (this.back.address.value == null) {
            this.back.address.value = value;
            return this.back.address;
        }
        this.front.address.nextElement = new MyQueue<T>(value, this.back, this.front);
        this.front.address.nextElement.previousElement = this.front.address;
        this.front.setAddress(this.front.address.nextElement);
        if (this.back.address.value == null) this.back.setAddress(nextElement);
        return nextElement;
    }

    public T dequeue() {
        T value = this.back.address.value;
        if (this.back.address.nextElement != null) {
            this.back.setAddress(this.back.address.nextElement);
            this.back.address.previousElement = null;
        } else {
            this.back.address.value = null;
        }
        return value;
    }

    public T peek() {
        return (T) this.back.address.value;
    }

    static class Element<T> {
        MyQueue<T> address;

        public Element(MyQueue<T> address) {
            this.address = address;
        }

        public void setAddress(MyQueue<T> address) {
            this.address = address;
        }
    }

}
