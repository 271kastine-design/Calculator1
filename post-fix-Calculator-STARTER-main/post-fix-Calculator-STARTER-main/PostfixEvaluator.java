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
        BoundedStackInterface<Integer> stack = new ArrayStack<>(100);
        Scanner tokens = new Scanner(expression);
        int i = 0;
        while(tokens.hasNext()){
            if(expression.charAt(i) == '+'){
                int a = stack.top();
                stack.pop();
                int b = stack.top();
                stack.pop();
                stack.push(a+b);
            }
            else if(expression.charAt(i) == '-'){
                int a = stack.top();
                stack.pop();
                int b = stack.top();
                stack.pop();
                stack.push(a-b);
            }
            else if(expression.charAt(i) == '*'){
                int a = stack.top();
                stack.pop();
                int b = stack.top();
                stack.pop();
                stack.push(a*b);
            }
            else if(expression.charAt(i) == '/'){
                int a = stack.top();
                stack.pop();
                int b = stack.top();
                stack.pop();
                stack.push(a/b);
            }
            i++;
        }
        for(int i = 0; i < expression.length();i++){
            if(expression.charAt(i) == '+'|| expression.charAt(i) == '/' || expression.charAt(i) == '*' || expression.charAt(i) == '-'){

            }
            stack.push(tokens.parseInt((i,i+1)));
        }
        stack.push()
        // TODO 1: Process tokens one at a time.
        // TODO 2: If a token is an integer, push it onto the stack.
        // TODO 3: If it is +, -, *, or /, pop two operands.
        //         IMPORTANT: the first popped number is the RIGHT operand.
        // TODO 4: Calculate and push the result.
        // TODO 5: Reject unknown tokens and expressions with too few operands.
        // TODO 6: After processing, require EXACTLY one result on the stack.
        //         Catch stack underflow/overflow or check before operations.
        // Close the Scanner when you are finished.

        tokens.close();
        throw new UnsupportedOperationException("TODO: implement postfix evaluation");
    }
}
