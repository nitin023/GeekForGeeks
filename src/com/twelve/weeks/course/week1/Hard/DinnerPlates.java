package com.twelve.weeks.course.week1.Hard;

import java.util.*;

public class DinnerPlates {

    int capacity;
    int left;
    int right;
    int count;
    Map<Integer, Stack<Integer>> stackMap;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.left = this.right = this.count = 0;
        this.stackMap = new HashMap<>();
        this.stackMap.put(left,new Stack<>());
    }

    public void push(int val) {
        while (stackMap.containsKey(left) && stackMap.get(left).size()==capacity) {
            left++;
        }

        stackMap.putIfAbsent(left, new Stack<>());
        stackMap.get(left).push(val);
        right = Math.max(left, right);
        count++;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        while (right >= 0 && stackMap.get(right).isEmpty()) {
            right--;
        }
        count--;
        left = Math.min(left, right);
        return stackMap.get(right).pop();
    }

    public int popAtStack(int index) {
        if (count == 0 || !stackMap.containsKey(index) || stackMap.get(index).isEmpty()) {
            return -1;
        }
        count--;
        left = Math.min(left, index);
        return stackMap.get(index).pop();
    }
}
