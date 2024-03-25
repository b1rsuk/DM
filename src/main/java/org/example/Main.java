package org.example;


import org.example.struct.DoublyList;
import org.example.struct.Queue;
import org.example.struct.Stack;

import java.util.Arrays;
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
            System.out.println("1 - stack");
            System.out.println("2 - queue");
            System.out.println("3 - list");
            int choice = Integer.parseInt(scanner.nextLine());
            clearConsole();


            switch (choice) {

                case (1): {
                    int method = getMethod("1 - push", "2 - pop");
                    switch (method) {
                        case (1):
                            int arg = Integer.parseInt(getArg());
                            stack.push(arg);
                            break;
                        case (2):
                            Integer deletedElem = stack.pop();
                            if (deletedElem == null) {
                                System.out.println("stack is empty");
                                break;
                            }
                            System.out.println("Deleted elem from stack: " + deletedElem);
                            break;
                    }
                    break;
                }
                case (2): {
                    int method = getMethod("1 - enqueue", "2 - dequeue");
                    switch (method) {
                        case (1):
                            int arg = Integer.parseInt(getArg());
                            queue.enqueue(arg);
                            break;
                        case (2):
                            Integer deletedElem = queue.dequeue();
                            if (deletedElem == null) {
                                System.out.println("queue is empty");
                                break;
                            }
                            System.out.println("Deleted elem from queue: " + deletedElem);
                            break;
                    }
                    break;
                }
                case (3): {
                    int method = getMethod(
                            "1 - addBegin",
                            "2 - addEnd",
                            "3 - delBegin",
                            "4 - delEnd",
                            "5 - delMid",
                            "6 - search",
                            "7 - addMid");

                    switch (method) {
                        case (1):
                            int arg1 = Integer.parseInt(getArg());
                            list.addBegin(arg1);
                            break;
                        case (2):
                            int arg2 = Integer.parseInt(getArg());
                            list.addEnd(arg2);
                            break;
                        case (3):
                            list.delBegin();
                            break;
                        case (4):
                            list.delEnd();
                            break;
                        case (5):
                            int arg3 = Integer.parseInt(getArg());
                            list.delMid(arg3);
                            break;
                        case (6):
                            int arg4 = Integer.parseInt(getArg());
                            list.search(arg4);
                            break;
                        case (7):
                            String arg5 = getArg();
                            String[] searchArg = arg5.split(", ");

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

    private static String getArg() {
        print("Arg: ");
        Scanner stackArgScanner = new Scanner(System.in);
        String arg = stackArgScanner.nextLine();

        return arg;
    }
    private static void print(String ...methods) {
        Arrays.stream(methods).forEach(System.out::println);
    }

    private static int getMethod(String ...methods) {
        print(methods);
        Scanner stackMethodScanner = new Scanner(System.in);
        return Integer.parseInt(stackMethodScanner.nextLine());
    }
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

}