package GeekForGeeks.Amazon;

import java.util.Iterator;
import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1
 * Medium
 */
public class MinimumElemInStack {
    int minEle;
    Stack<Integer> s;

    public MinimumElemInStack() {
        this.s = new Stack();
        this.minEle = Integer.MAX_VALUE;
    }

    int getMin() {
        // Your code here
        if (this.s.isEmpty()) {
            return -1;
        }
        return this.minEle;
    }

    /*returns poped element from stack*/
    int pop() {
        // Your code here
        if (!this.s.isEmpty()) {
            int elemPopped = this.s.pop();
            this.minEle = Integer.MAX_VALUE;

            Iterator value = this.s.iterator();
            while (value.hasNext()) {
                this.minEle = Math.min(this.minEle, (Integer) value.next());
            }
            return elemPopped;
        } else {
            return -1;
        }
    }

    /*push element x into the stack*/
    void push(int x) {
        // Your code here
        this.minEle = Math.min(x, this.minEle);
        this.s.push(x);
    }
}
