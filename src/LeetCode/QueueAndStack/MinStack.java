package LeetCode.QueueAndStack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
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
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 */
public class MinStack {

    private int top ;
    private int stack[] ;

    public MinStack() {
        stack = new int[100];
        top = -1;
    }

    public void push(int x) {
        stack[++top] = x;
    }

    public void pop() {
        top--;
    }

    public int top() {
        return  stack[top];
    }

    public int getMin() {
        int minValue = Integer.MAX_VALUE;
        for(int i = 0 ; i<=top ; i++)
        {
            if(minValue > stack[i])
            {
                minValue = stack[i];
            }
        }
        return minValue;
    }
}
