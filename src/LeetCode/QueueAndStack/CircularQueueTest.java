package LeetCode.QueueAndStack;

public class CircularQueueTest {

    public static void main(String[] args) {
        MyCircularQueue designCircularQueue = new MyCircularQueue(3);
        System.out.println(designCircularQueue.enQueue(1));
        System.out.println(designCircularQueue.enQueue(2));
        System.out.println(designCircularQueue.enQueue(3));
        System.out.println(designCircularQueue.enQueue(4));

        System.out.println(designCircularQueue.Rear());
        System.out.println(designCircularQueue.isFull());

        System.out.println(designCircularQueue.deQueue());
        System.out.println(designCircularQueue.enQueue(4));
        System.out.println(designCircularQueue.Rear());
    }
}
