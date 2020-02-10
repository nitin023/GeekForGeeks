package ImplementDataStructure;


public class MyHashMap<K,V> {

    private Entry<K, V>[] buckets;
    private static int INITIAL_CAPACITY = 1<<4;
    private int size = 0;

    public MyHashMap()
    {
        this(INITIAL_CAPACITY);
    }

    public MyHashMap(int capacity)
    {
        this.buckets = new Entry[capacity];
    }

    public void put(K key , V value)
    {
        Entry<K,V> entry = new Entry<>(key,value,null);
        int bucket = key.hashCode() % buckets.length;

        Entry<K,V> existing = buckets[bucket];
        if(existing == null)
        {
            buckets[bucket] = entry;
            size++;
        }
        else
        {
            while (existing.next !=null)
            {
                if(existing.key.equals(key))
                {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if(existing.key.equals(key))
            {
                existing.value = value;
            }
            else {
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key)
    {
        int bucket = key.hashCode() % buckets.length;
        Entry<K,V> existing = buckets[bucket];
        if(existing == null)
        {
            return null;
        }
        while (existing !=null)
        {
            if(existing.key.equals(key))
            {
                return existing.value;
            }
            existing = existing.next;
        }
        return null;
    }
}

class Entry<K,V>{
    final K key;
    V value;
    Entry<K,V> next;

    public Entry(K key , V value , Entry<K,V> next)
    {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry<K, V> getNext() {
        return next;
    }
}
