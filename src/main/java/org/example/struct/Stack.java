package org.example.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack<T> {
    private final List<T> stack = new ArrayList<>();


    public Stack(T[] arr) {
        stack.addAll(Arrays.asList(arr));
    }

    private int getLastElem() {
        return (this.stack.size() - 1);
    }

    public T peek() {
        verifyStack();

        int lastElemIndex = getLastElem();
        this.show(lastElemIndex);

        return stack.get(lastElemIndex);
    }

    public T pop() {
        verifyStack();

        int lastElemIndex = getLastElem();
        this.show(lastElemIndex);

        return this.stack.remove(lastElemIndex);
    }

    private void verifyStack() {
        if (this.stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
    }

    public void show(int index) {
        T elem = this.stack.get(index);
        System.out.println(elem);
    }

    public void show() {
        System.out.println(stack);
    }

}
