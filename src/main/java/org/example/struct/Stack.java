package org.example.struct;

public class Stack<T> extends NodeList<T> {

    public void push(T elem) {
        super.push(elem);
    }

    public T pop() {
        Node<T> current = super.head;
        Node<T> previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            super.head = null;
        } else {
            previous.next = null;
        }

        return current.data;
    }


}
