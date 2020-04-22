package LeetCode.QueueAndStack;

import java.util.*;

/**
 * Clone Graph
 * <p>
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * <p>
 * Test case format:
 * <p>
 * For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.
 * <p>
 * Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 * <p>
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 * <p>
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * <p>
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list.
 * The graph consists of only one node with val = 1 and it does not have any neighbors.
 * <p>
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * <p>
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * Number of Nodes will not exceed 100.
 * There is no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 */
public class CloneGraph {

    public static void main(String[] args) {
        Node graph = new Node(1, new ArrayList(Arrays.asList(2)));
        cloneGraph(graph);
        }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private static Node cloneGraph(Node node, Map<Integer, Node> map) {

        if(map.containsKey(node.val))
        {
            return map.get(node.val);
        }
        Node copyNode =  new Node(node.val);
        map.put(copyNode.val,copyNode);

        for(Node neighbour : node.neighbors)
        {
            copyNode.neighbors.add (cloneGraph(neighbour,map));
        }
        return copyNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
