package LeetCode.QueueAndStack;

/**
 * Design Circular Queue
 * <p>
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * <p>
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * <p>
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * <p>
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * <p>
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * <p>
 * isEmpty(): Checks whether the circular queue is empty or not.
 * <p>
 * isFull(): Checks whether the circular queue is full or not.
 *
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Queue library.
 * <p>
 * <p>
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
public class MyCircularQueue {

    int front;
    int rear;
    int[] data;
    int SIZE;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {

        //queue state is empty as of now thats why front and rear are both set to -1
        data = new int[k];
        front = -1;
        rear = -1;
        SIZE = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % SIZE;
        data[rear] = value;

        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        if (front == rear){
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % SIZE;
        }

        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if(isEmpty())
        {
            return -1;
        }
        return this.data[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(isEmpty())
        {
            return -1;
        }
        return this.data[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return front == 0 && rear == data.length - 1 || (front == rear + 1);
    }
}
