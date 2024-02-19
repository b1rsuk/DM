package org.example.struct;

import java.util.Collection;

public class NodeList<T> {
    Node<T> head;


    protected void push(T newData) {
        Node<T> newNode = new Node<>(newData);
        if (this.head == null) {
            this.head = newNode;
            return;
        }

        Node<T> current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<T> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");

        return result.toString();
    }

}
