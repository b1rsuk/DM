package org.example;


import org.example.struct.DoublyList;
import org.example.struct.Node;
import org.example.struct.Queue;
import org.example.struct.Stack;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("STACK");
        Stack<Integer> stack = new Stack<>(){
            @Override
            public void push(Integer newData) {
                super.push(newData);
                System.out.printf("Add to stack: %s. New stack is %s\n", newData, this);
            }

            @Override
            public Integer pop() {
                Integer deleted = super.pop();
                System.out.println("Deleted from stack " + deleted);

                return deleted;
            }
        };
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();

        System.out.println(stack);

        System.out.println("QUEUE");

        Queue<Integer> queue = new Queue<>() {
            @Override
            public void enqueue(Integer newData) {
                super.push(newData);
                System.out.printf("Add to queue: %s. New queue is %s\n", newData, this);
            }

            @Override
            public Integer dequeue() {
                Integer deleted = super.dequeue();
                System.out.println("Deleted from dequeue " + deleted);

                return deleted;
            }
        };

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.dequeue();

        System.out.println(queue);

        System.out.println("DOUBLY LIST");
        DoublyList<Integer> doublyList = new DoublyList<>() {
            @Override
            public void addBegin(Integer newData) {
                super.addBegin(newData);
                System.out.printf("Add to doublyList: %s. New doublyList is %s\n", this, newData);
            }

            @Override
            public void addEnd(Integer newData) {
                super.addEnd(newData);
                System.out.printf("Add to end doublyList: %s. New doublyList is %s\n", this, newData);
            }

            @Override
            public Integer delBegin() {
                Integer deleted = super.delBegin();
                System.out.println(deleted);
                System.out.printf("Deleted from doublyList: %s. New doublyList is %s\n", deleted, this);

                return deleted;
            }

            @Override
            public Integer delEnd() {
                Integer deleted = super.delEnd();
                System.out.printf("Deleted from end of doublyList: %s. New doublyList is %s\n", deleted, this);

                return deleted;
            }

            @Override
            public boolean addMid(Integer key, Integer newData) {
                boolean addMid = super.addMid(key, newData);
                System.out.printf("Add after %d. New doubly list: %s\n", key, this);

                return addMid;
            }

            @Override
            public boolean delMid(Integer key) {
                boolean delMid = super.delMid(key);
                System.out.printf("Successfully deleted element with key %d\n", key);

                return delMid;
            }

        };
        doublyList.addBegin(1);
        doublyList.addBegin(2);
        doublyList.addBegin(3);
        doublyList.addBegin(4);
        doublyList.addBegin(5);
        doublyList.addBegin(6);
        doublyList.addEnd(9);
        doublyList.delBegin();
        doublyList.delEnd();
        doublyList.search(5);
        doublyList.addMid(5, 3);
        doublyList.delMid(2);

        System.out.println(doublyList);
    }



}