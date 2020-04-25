package LeetCode.QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement Stack using Queues
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * <p>
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class MyStack {

    private List<Integer> stackSimilator;
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
        stackSimilator = new ArrayList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        stackSimilator = new ArrayList<>();

        while (!queue.isEmpty()) {
            stackSimilator.add(queue.poll());
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.add(x);
        tmp.addAll(stackSimilator);

        queue.addAll(tmp);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.isEmpty() ?  -1 : queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.isEmpty() ?  -1 : queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
