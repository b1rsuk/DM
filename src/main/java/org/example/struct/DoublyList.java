package org.example.struct;

public class DoublyList<T> extends NodeList<T> {

    public T delBegin() {

        Node<T> current = this.head;
        T elem = current.data;

        this.head = current.next;
        return elem;
    }

    public Node<T> search(T key) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.data.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean addMid(T key, T newData) {
        Node<T> foundNode = search(key);
        if (foundNode == null) {
            return false;
        }

        Node<T> newNode = new Node<>(newData);
        newNode.next = foundNode.next;
        if (foundNode.next != null) {
            foundNode.next.previous = newNode;
        }
        foundNode.next = newNode;
        newNode.previous = foundNode;
        return true;
    }

    public boolean delMid(T key) {
        Node<T> foundNode = search(key);
        if (foundNode == null || foundNode == this.head) {
            return false;
        }

        if (foundNode.next != null) {
            foundNode.next.previous = foundNode.previous;
        }
        foundNode.previous.next = foundNode.next;
        return true;
    }

    public T delEnd() {
        if (this.head == null) {
            throw new RuntimeException();
        }

        if (this.head.next == null) {
            T data = this.head.data;
            this.head = null;
            return data;
        }

        Node<T> current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        return data;

    }

    public void addBegin(T newData) {
        Node<T> newNode = new Node<>(newData);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
    }

    public void addEnd(T newData) {
        Node<T> newNode = new Node<>(newData);
        Node<T> current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }
}
