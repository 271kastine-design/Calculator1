import java.util.Scanner;

/** STUDENT FILE: Complete evaluate. Leave all other project files unchanged. */
public class PostfixEvaluator {
    /**
     * Evaluates a space-separated postfix expression using integer arithmetic.
     * Supported operators: +, -, *, / (integer division).
     *
     * @throws PostFixException for blank, malformed, or invalid expressions
     * @throws ArithmeticException for division by zero
     */
    public static int evaluate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new PostFixException("Expression must not be blank.");
        }

        BoundedStackInterface<Integer> stack = new ArrayStack<>(100);
        int operandCount = 0;

        try (Scanner tokens = new Scanner(expression)) {
            while (tokens.hasNext()) {
                String token = tokens.next();

                if (token.equals("+") || token.equals("-")
                        || token.equals("*") || token.equals("/")) {
                    if (operandCount < 2) {
                        throw new PostFixException("Operator has too few operands: " + token);
                    }

                    int right = stack.top();
                    stack.pop();
                    int left = stack.top();
                    stack.pop();
                    operandCount -= 1;

                    int result;
                    switch (token) {
                        case "+":
                            result = left + right;
                            break;
                        case "-":
                            result = left - right;
                            break;
                        case "*":
                            result = left * right;
                            break;
                        default:
                            result = left / right;
                            break;
                    }

                    stack.push(result);
                } else {
                    final int number;
                    try {
                        number = Integer.parseInt(token);
                    } catch (NumberFormatException exception) {
                        throw new PostFixException("Invalid token: " + token);
                    }

                    if (stack.isFull()) {
                        throw new PostFixException("Expression contains too many operands.");
                    }
                    stack.push(number);
                    operandCount += 1;
                }
            }
        }

        if (operandCount != 1) {
            throw new PostFixException("Expression must leave exactly one result.");
        }
        return stack.top();
    }
}
