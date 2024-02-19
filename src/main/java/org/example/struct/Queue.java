package org.example.struct;

public class Queue<T> extends NodeList<T> {
    public void enqueue(T elem) {
        super.push(elem);
    }

    public T dequeue() {
        T data = head.data;
        super.head = head.next;
        return data;
    }
}
