package com.twelve.weeks.course.week1.Easy;


public class Executor {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);
        hashSet.contains(3);
        hashSet.add(2);
        hashSet.contains(2);
        hashSet.remove(2);
        hashSet.contains(2);
    }
}
