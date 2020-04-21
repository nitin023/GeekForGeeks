package LeetCode.QueueAndStack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("}}"));
    }

    public static boolean isValid(String s) {

        if (s.isEmpty()) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }

        Stack<Character> parenthesisStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentParenthesis = s.charAt(i);

            //open bracket case do only insertion in stack
            if (currentParenthesis == '(' || currentParenthesis == '{' || currentParenthesis == '[') {
                parenthesisStack.push(currentParenthesis);
            } else {
                if(parenthesisStack.isEmpty())
                {
                    return false;
                }
                char popedOutChar = parenthesisStack.pop();
                if (!((currentParenthesis == ')' && popedOutChar == '(')
                        || (currentParenthesis == '}' && popedOutChar == '{')
                        || (currentParenthesis == ']' && popedOutChar == '['))) {
                    return false;
                }
            }
        }

        return parenthesisStack.isEmpty();
    }
}
