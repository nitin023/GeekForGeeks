package LeetCode.QueueAndStack;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 * Solution
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        int evalResult = 0;
        if (tokens == null || tokens.length == 0) {
            return evalResult;
        }

        Stack<String> rpnExpression = new Stack<>();

        for (String currentElement : tokens) {
            //+, -, *, /
            if (!isOperator(currentElement)) {
                rpnExpression.push(currentElement);
            } else {
                //pop top two elements from stack
                String operand1 = rpnExpression.pop();
                String operand2 = rpnExpression.pop();
                int result = getUpdatedResult(operand1, operand2, currentElement);
                rpnExpression.push(result + "");
            }
        }
        return !rpnExpression.isEmpty() ? Integer.parseInt(rpnExpression.pop()) : 0;
    }

    private static boolean isOperator(String string) {
        return string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/");
    }

    private static int getUpdatedResult(String operand1, String operand2, String operation) {
        int evalResult = 0;
        switch (operation) {
            case "+":
                evalResult += (Integer.parseInt(operand2) + Integer.parseInt(operand1));
                break;
            case "-":
                evalResult += (Integer.parseInt(operand2) - Integer.parseInt(operand1));
                break;
            case "*":
                evalResult += (Integer.parseInt(operand2) * Integer.parseInt(operand1));
                break;
            case "/":
                evalResult += (Integer.parseInt(operand2) / Integer.parseInt(operand1));
                break;
        }
        return evalResult;
    }
}
