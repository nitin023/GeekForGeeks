package LeetCode.Recursion;

/**
 * Given n, how many structurally unique BST's
 * (binary search trees) that store values 1 ... n?
 */
public class UniqueBinarySearchTreesDPT {

    public static void main(String[] args) {

        System.out.println(numTreesIteratively(5));
    }

    public static int numTreesIteratively(int n) {
        if(n==0)
        {
            return 0;
        }
        int []T = new int[n+1];
        T[0] = T[1] = 1;

        for(int i = 2 ; i<=n ; i++)
        {
            int sum = 0;
            int a = 0 ;int b = i-1;
            while (a>=0 && b>=0)
            {
                sum+=T[a++] * T[b--];
            }
            T[i] = sum;
        }
        return T[n];
    }
}
