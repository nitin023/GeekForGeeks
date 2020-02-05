package ImplementDataStructure;

public class DataStructureImplementation {

    public static void main(String[] args)
    {
        LeastRecentlyUsedCache leastRecentlyUsedCache = new LeastRecentlyUsedCache(5);
        leastRecentlyUsedCache.put(1,12);
        leastRecentlyUsedCache.put(2,53);
        leastRecentlyUsedCache.put(4,32);
        leastRecentlyUsedCache.put(5,13);
        leastRecentlyUsedCache.put(6,83);
        leastRecentlyUsedCache.put(7,54);
        System.out.println(leastRecentlyUsedCache.get(6));
    }
}
