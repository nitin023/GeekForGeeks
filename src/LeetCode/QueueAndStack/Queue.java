package LeetCode.QueueAndStack;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 */

/**
 * Solution comments
 *
 * Solved using two stack
 * whenever we push we first shift all the elements
 * to the second stack
 * and then we add new element two the first stack
 * and then we remove all elements from second stack and add
 * them to stack1 to give them queue behavior
 */
public class Queue {

    /**
     * Initialize your data structure here.
     */

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {

        if(stack1.isEmpty())
        {
            stack1.push(x);
            return;
        }

        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while (!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return !stack1.isEmpty() ? stack1.pop() : -1;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return !stack1.isEmpty() ? stack1.peek() : -1;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {

        return stack1.isEmpty();
    }
}
