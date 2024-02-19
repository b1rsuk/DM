package org.example;


import org.example.struct.Stack;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stack<Integer> stack = new Stack<>(arr);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.show());
    }

}