package interpreter;

public class OperationExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private OperationType operation;

    public OperationExpression(Expression leftExpression, Expression rightExpression, OperationType operation) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    @Override
    public int interpret() {
        switch (operation) {
            case ADDITION:
                return leftExpression.interpret() + rightExpression.interpret();
            case SUBTRACTION:
                return leftExpression.interpret() - rightExpression.interpret();
            default:
                throw new IllegalStateException("Unsupported operation");
        }
    }
}
