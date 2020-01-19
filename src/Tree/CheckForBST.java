package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Given a binary tree, return true if it is BST, else false. For example, the following tree is not BST, because 11 is in left subtree of 10. The task is to complete the function isBST() which takes one argument, root of Binary Tree.
 *
 *         10
 *      /     \
 *    7       39
 *      \
 *       11
 *
 * Input:
 * The input contains T, denoting number of testcases. For each testcase there will be two lines. The first line contains number of edges. The second line contains two nodes and a character separated by space. The first node denotes data value, second node denotes where it will be assigned to the previous node which will depend on character 'L' or 'R' i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on. The first node of second line is root node. The struct or class Node has a data part which stores the data, pointer to left child and pointer to right child. There are multiple test cases. For each test case, the function will be called individually.
 *
 * Output:
 * The function should return 1 if BST else return 0.
 *
 * User Task:
 * Since this is a functional problem you don't have to worry about input, you just have to complete the function isBST().
 *
 * Constraints:
 * 1 <= T <= 100
 * 0 <= Number of edges <= 100
 * 1 <= Data of a node <= 1000
 *
 * Example:
 * Input:
 * 2
 * 2
 * 1 2 R 1 3 L
 * 4
 * 10 20 L 10 30 R 20 40 L 20 60 R
 *
 * Output:
 * 0
 * 0
 */
public class CheckForBST {

    public static void main(String[] args){
        Node root = new Node(100);
        root.left = new Node(80);
        root.right = new Node(130);
        root.left.left = new Node(40);
        root.left.right = new Node(90);
        System.out.println(isBST(root));
    }

    public static int isBST(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int response = 0;
        List<Integer> inorderTraversal = new ArrayList<>();
        getInorderTraversal(root,inorderTraversal);

        for(int i = 0 ; i+1 < inorderTraversal.size() ; i++)
        {
            if(inorderTraversal.get(i) > inorderTraversal.get(i+1))
            {
                response = 0;
                break;
            }
            else
            {
                response = 1;
            }
        }
        return response;
    }

    private static void getInorderTraversal(Node node,List<Integer> inorderTraversal)
    {
        if(node == null)
        {
            return;
        }

        getInorderTraversal(node.left , inorderTraversal);
        inorderTraversal.add(node.data);
        getInorderTraversal(node.right,inorderTraversal);
    }
}

//10 20 L 10 30 R 20 40 L 20 60 R
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}