package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Expression: ");

        String expression = scanner.nextLine();
        System.out.print("1 - infixToPostfix. 2 - infixToPrefix. Method: ");
        String method = scanner.nextLine();

        scanner.close();

        if ("1".equals(method)) {
            System.out.println(String.format("infixToPostfix(%s): %s", expression, ExpressionConverter.infixToPostfix(expression)));
        }
        else if ("2".equals(method)) {
            System.out.println(String.format("infixToPrefix(%s): %s", expression, ExpressionConverter.infixToPrefix(expression)));
        }

    }
}