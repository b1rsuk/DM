package org.example;

import java.util.Stack;

public final class ExpressionConverter {

    public static String infixToPostfix(String infixExpression) {
        StringBuilder output = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();

        for (char s : infixExpression.toCharArray()) {
            if (isOperand(s)) {
                output.append(s);
            }
            else if (isOperator(s)) {
                operatorStack.add(String.valueOf(s));
            }
            else if (s == ')') {
                output.append(operatorStack.pop());
            }
        }

        return output.toString();
    }


    public static String infixToPrefix(String infixExpression) {
        char[] reversedInfix = new StringBuilder(infixExpression).reverse().toString().toCharArray();
        for (int i = 0; i < reversedInfix.length; i++) {
            char current = reversedInfix[i];
            if (current == '(') {
                reversedInfix[i] = ')';
            }
            else if (current == ')') {
                reversedInfix[i] = '(';
            }
        }

        String postfix = infixToPostfix(new String(reversedInfix));


        return new StringBuilder(postfix).reverse().toString();
    }

    private static boolean isOperator(char s) {
        return (s == '+' || s == '-' || s == '*' || s == '/');
    }

    public static boolean isOperand(char s) {
        return Character.isDigit(s);
    }

}
