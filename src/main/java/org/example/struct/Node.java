package org.example.struct;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;


    Node(T d) {
        data = d;
        next = null;
    }

}