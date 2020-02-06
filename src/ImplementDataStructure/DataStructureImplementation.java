package ImplementDataStructure;

public class DataStructureImplementation {

    public static void main(String[] args)
    {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abgl");
        trie.insert("cdf");
        trie.insert("abcd");
        trie.insert("lmn");

        System.out.println(trie.search("abk"));
    }
}
