package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Expression: ");

        String expression = scanner.nextLine();
        System.out.print("1 - infixToPostfix. 2 - infixToPrefix. 3 - postfixToInfix. 4 - prefixToInfix. Method: ");
        String choice = scanner.nextLine();

        scanner.close();

        switch (choice) {
            case "1": {
                String out = generateOutput("infixToPostfix", expression, ExpressionConverter.infixToPostfix(expression));
                System.out.println(out);
                return;
            }
            case "2": {
                String out = generateOutput("infixToPrefix", expression, ExpressionConverter.infixToPrefix(expression));
                System.out.println(out);
                return;
            }
            case "3": {
                String out = generateOutput("postfixToInfix", expression, ExpressionConverter.postfixToInfix(expression));
                System.out.println(out);
                return;
            }
            case "4": {
                String out = generateOutput("prefixToInfix", expression, ExpressionConverter.prefixToInfix(expression));
                System.out.println(out);
                return;
            }
        }
    }
    private static String generateOutput(String operation, String expression, String result) {
        return String.format("%s(%s): %s", operation, expression, result);
    }
}