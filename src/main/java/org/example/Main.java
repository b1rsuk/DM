package org.example;


import jline.console.ConsoleReader;
import org.example.struct.DoublyList;
import org.example.struct.Node;
import org.example.struct.Queue;
import org.example.struct.Stack;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new Queue<>();
        DoublyList<Integer> list = new DoublyList<>();

        while (true) {
            System.out.print("STACK: ");
            System.out.println(stack);
            System.out.print("QUEUE: ");
            System.out.println(queue);

            System.out.print("DOUBLY LIST: ");
            System.out.println(list);

            Scanner scanner = new Scanner(System.in);
            String[] choice = scanner.nextLine().split("[\\.\\(\\)]");
            clearConsole();

            String struct = choice[0];
            String method = choice[1];

            String arg = null;
            if (choice.length == 3) {
                 arg = choice[2];
            }

            switch (struct) {

                case ("stack"): {
                    switch (method) {
                        case ("push"):
                            stack.push(Integer.parseInt(arg));
                            break;
                        case ("pop"):
                            int deletedElem = stack.pop();
                            System.out.println("Deleted elem from stack: " + deletedElem);
                            break;
                    }
                    break;
                }
                case ("queue"): {
                    switch (method) {
                        case ("enqueue"):
                            queue.enqueue(Integer.parseInt(arg));
                            break;
                        case ("dequeue"):
                            int deletedElem = queue.dequeue();
                            System.out.println("Deleted elem from queue: " + deletedElem);
                            break;
                    }
                    break;
                }
                case ("list"): {
                    switch (method) {
                        case ("addBegin"):
                            list.addBegin(Integer.parseInt(arg));
                            break;
                        case ("addEnd"):
                            list.addEnd(Integer.parseInt(arg));
                            break;
                        case ("delBegin"):
                            list.delBegin();
                            break;
                        case ("delEnd"):
                            list.delEnd();
                            break;
                        case ("delMid"):
                            list.delMid(Integer.parseInt(arg));
                            break;
                        case ("search"):
                            list.search(Integer.parseInt(arg));
                            break;
                        case ("addMid"):
                            String[] searchArg = arg.split(", ");

                            Integer key = Integer.parseInt(searchArg[0]);
                            Integer newData = Integer.parseInt(searchArg[1]);
                            list.addMid(key, newData);
                            break;
                    }
                    break;
                }
            }

        }

    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

}