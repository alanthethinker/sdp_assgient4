package interpreter;

public class InterpreterDemo {
    public static void main(String[] args) {
        String expression = "5 + 2 - 3";
        Expression parsedExpression = Interpreter.parse(expression);
        System.out.println("Expression: " + expression);
        System.out.println("Result: " + parsedExpression.interpret());
    }
}
