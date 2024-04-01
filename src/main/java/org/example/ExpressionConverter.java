package org.example;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.Arrays;
import java.util.List;
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
    public static String postfixToInfix(String postfixExpression) {
        Stack<String> expressionStack = new Stack<>();

        for (char s : postfixExpression.toCharArray()) {
            if (isOperand(s)) {
                expressionStack.add(String.valueOf(s));
                continue;
            }

            String operation1 = expressionStack.pop();
            String operation2 = expressionStack.pop();
            String newExpression = String.format("(%s %s %s)", operation1, s, operation2);

            expressionStack.add(newExpression);
        }

        return expressionStack.toString().replace("[", "").replace("]", "");
    }

    public static String prefixToInfix(String prefixExpression) {
        prefixExpression = new StringBuilder(prefixExpression).reverse().toString();

        return postfixToInfix(prefixExpression);
    }

    private static boolean isOperator(char s) {
        return (s == '+' || s == '-' || s == '*' || s == '/' || s == '^');
    }

    public static boolean isOperand(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
