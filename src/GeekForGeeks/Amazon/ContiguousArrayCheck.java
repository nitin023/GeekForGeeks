package GeekForGeeks.Amazon;

/**
 * https://practice.geeksforgeeks.org/problems/check-if-array-contains-contiguous-integers-with-duplicates-allowed/0
 * Easy
 *
 * Checking contiguous elements by sorted set and iterating over elem to find it is contiguous or not.
 *
 * Solution O(nlogn) checkForContiguousSet
 * Solved using treeSet sorting and checking for continuity.
 *
 * Solution(O(n)) areElementsContiguous
 * using hashset by picking any elem from set
 * and incrementing it to reach last possible order and maintaining count
 * now again pick the same element and start dec to lowest possible value inside set
 * now compare set size with this count
 * if count matches this means given set is contiguous.
 */

import java.util.*;

public class ContiguousArrayCheck {
    public static void main(String[] args)  {
        Scanner s=new Scanner(System.in);
        int t= s.nextInt();
        while (t > 0) {
            int n = s.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                treeSet.add(s.nextInt());
            }
            checkForContiguousSet(treeSet);
            t--;
        }
        areElementsContiguous(new ArrayList<>(Arrays.asList(5, 2, 3, 6, 4, 4, 6, 6)));
    }

    //o(nlogn) solution
    private static void checkForContiguousSet(TreeSet treeSet) {

        if (treeSet == null) {
            System.out.println("Yes");
            return;
        }
        List<Integer> list = new ArrayList<>(treeSet);

        int startVal = (list.get(0));
        for (int i = 1; i < list.size(); i++) {

            int nextNum = (list.get(i));
            if (nextNum - 1 != startVal) {
                System.out.println("No");
                return;
            } else {
                startVal = nextNum;
            }
        }
        System.out.println("Yes");
        return;
    }


    //o(n) solution
    private static Boolean areElementsContiguous(List<Integer> list)
    {
        HashSet<Integer> allElements = new HashSet<>(list);

        int countWhileIncrementing = 1 ;

        int startPoint = list.get(0);

        while (allElements.contains(startPoint+1))
        {
            startPoint++;
            countWhileIncrementing++;
        }
        startPoint = list.get(0);
        while (allElements.contains(startPoint-1))
        {
            startPoint--;
            countWhileIncrementing++;
        }

        return (countWhileIncrementing  == allElements.size() - 1);
    }
}
