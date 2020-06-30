package com.twelve.weeks.course.week1.Easy;

import java.util.Stack;

/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * Solution approach is to create two stacks one to store main content second one to store
 * min elements as per elements inserted now.
 * https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 */
public class MinimumStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack;
    Stack<Integer> auxillary;

    public MinimumStack() {
        stack = new Stack();
        auxillary = new Stack();
    }

    public void push(int x) {

        if (stack.isEmpty()) {
            stack.push(x);
            auxillary.push(x);
        } else {
            stack.push(x);
            int y = auxillary.peek();
            if (x < y) {
                auxillary.push(x);
            } else {
                auxillary.push(y);
            }
        }
    }

    public void pop() {
        stack.pop();
        auxillary.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        return auxillary.peek();
    }
}
