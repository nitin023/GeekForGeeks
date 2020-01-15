package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.
 * <p>
 * Output:
 * Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ |s| ≤ 105
 * <p>
 * Example:
 * Input:
 * 3
 * {([])}
 * ()
 * ([]
 * <p>
 * Output:
 * balanced
 * balanced
 * not balanced
 */
public class ParenthesisChecker {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            checkParenthesisBalancing(br.readLine());
            testCases--;
        }
    }

    /**
     * The algo works as
     * Declare a character stack S.
     * Now traverse the expression string exp.
     * If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
     * If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
     * After complete traversal, if there is some starting bracket left in stack then “not balanced”
     *
     * @param input
     */
    public static void checkParenthesisBalancing(String input) {
        Stack<Character> openingBrackStacks = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                openingBrackStacks.push(currChar);
            } else {
                char popedElem;
                if (!openingBrackStacks.isEmpty()) {
                    popedElem = openingBrackStacks.pop();
                    if (currChar == ')' && popedElem != '(') {
                        System.out.println("not balanced");
                        return;
                    } else if (currChar == ']' && popedElem != '[') {
                        System.out.println("not balanced");
                        return;
                    } else if (currChar == '}' && popedElem != '{') {
                        System.out.println("not balanced");
                        return;
                    }
                } else {
                    System.out.println("not balanced");
                    return;
                }
            }
        }
        if (openingBrackStacks.isEmpty()) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }
    }
}
