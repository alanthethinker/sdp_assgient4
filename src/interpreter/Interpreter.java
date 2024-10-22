package interpreter;

import java.util.Stack;

public class Interpreter {
    public static Expression parse(String input) {
        String[] tokens = input.split(" ");
        Stack<Expression> expressions = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                expressions.push(new NumberExpression(Integer.parseInt(tokens[i])));
            } else if (isOperator(tokens[i])) {
                if (i + 1 >= tokens.length || !isNumber(tokens[i + 1])) {
                    throw new IllegalArgumentException("Invalid expression format");
                }

                Expression right = new NumberExpression(Integer.parseInt(tokens[i + 1]));
                Expression left = expressions.pop();
                OperationType operation = tokens[i].equals("+") ? OperationType.ADDITION : OperationType.SUBTRACTION;

                expressions.push(new OperationExpression(left, right, operation));
                i++;
            }
        }

        return expressions.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-");
    }
}