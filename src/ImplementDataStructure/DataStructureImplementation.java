package ImplementDataStructure;

public class DataStructureImplementation {

    public static void main(String[] args) {
        MyHashMap<String,Integer> customMap = new MyHashMap<>();
        customMap.put("qw",1);
        customMap.put("q" , 2);
        customMap.put("w" ,3);
        customMap.put("n",7);
        System.out.println(customMap.get("q"));
    }
}
