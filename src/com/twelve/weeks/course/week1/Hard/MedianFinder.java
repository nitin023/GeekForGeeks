package com.twelve.weeks.course.week1.Hard;

import java.util.*;

public class MedianFinder {

    List<Integer> list;

    public MedianFinder() {
        this.list = new ArrayList<>();
    }

    public void addNum(int num) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (num < list.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        list.add(start, num);
    }

    public double findMedian() {
        if (list.size() == 0) return -1;
        int mid = list.size() / 2;
        if (list.size() % 2 == 0) {
            return (list.get(mid) + list.get(mid - 1)) * 0.5;
        }
        return list.get(mid);
    }
}
