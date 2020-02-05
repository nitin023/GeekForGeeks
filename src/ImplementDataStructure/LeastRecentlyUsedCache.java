package ImplementDataStructure;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {

    Map<Integer, ListNode> hashtable = new HashMap<Integer, ListNode>();
    ListNode head;
    ListNode tail;

    int totalItemsInCache;
    int maxCapacity;

    public LeastRecentlyUsedCache(int maxCapacity) {
        // Cache starts empty and capacity is set by client
        totalItemsInCache = 0;
        this.maxCapacity = maxCapacity;

        // Dummy head and tail nodes to avoid empty states
        head = new ListNode();
        tail = new ListNode();

        // Wire the head and tail together
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
       ListNode newCacheNode = hashtable.get(key);
       if(newCacheNode == null)
       {
           newCacheNode = new ListNode();
           newCacheNode.key = key;
           newCacheNode.value = value;
       }
        //overflow
        if(totalItemsInCache == maxCapacity)
        {
            totalItemsInCache--;
            ListNode tailPrevNode = tail.prev.prev;
            tailPrevNode.next = tail;
            hashtable.remove(tailPrevNode.key);
        }

        ListNode headNextNode = head.next;
        newCacheNode.prev = head;
        newCacheNode.next = headNextNode;
        headNextNode.prev = newCacheNode;
        head.next = newCacheNode;
        totalItemsInCache++;
        hashtable.put(key,newCacheNode);
    }

    public int get(int key)
    {
        if(!hashtable.containsKey(key))
        {
            return -1;
        }
        ListNode newCacheNode = hashtable.get(key) ;
        ListNode headNextNode = head.next;
        newCacheNode.prev.next = newCacheNode.next;
        newCacheNode.next.prev = newCacheNode.prev;
        newCacheNode.prev = head;
        newCacheNode.next = headNextNode;
        headNextNode.prev = newCacheNode;
        head.next = newCacheNode;

        return  hashtable.get(key).value;
    }
}


 class ListNode {
    int key;
    int value;

    ListNode prev;
    ListNode next;
}
