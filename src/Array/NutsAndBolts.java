package Array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
 *
 * Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
 *
 * Input:
 * The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:
 * Each case begins with a single positive integer N denoting the number of nuts/bolts. Then follows the array of nuts, each element separated by a space. And finally the bolts array, again, each element is separated by a space here. Array of Nuts/Bolts can only consist of the following elements:{'@', '#', '$', '%', '^', '&', '~', '*', '!'}. And no element can be repeated.
 *
 * Output:
 * For each test case, output the matched array of nuts and bolts in separate lines, where each element in the array is separated by a space. Print the elements in the following order ! # $ % & * @ ^ ~
 *
 * Constraints:
 * 1 <= T <= 70
 * 1 <= N <= 9
 *
 * Example:
 * Input:
 * 2
 * 5
 * @ % $ # ^
 * % @ # $ ^
 * 9
 * ^ & % @ # * $ ~ !
 * ~ # @ % & * $ ^ !
 *
 * Output:
 * # $ % @ ^
 * # $ % @ ^
 * ! # $ % & * @ ^ ~
 * ! # $ % & * @ ^ ~
 */
public class NutsAndBolts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases , nutsCnt;
        testCases = sc.nextInt();
        while (testCases > 0) {
            nutsCnt = sc.nextInt();
            Set<Character> nutsSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 1 ; i<=nutsCnt ; i++)
            {
                nutsSet.add(sc.next().charAt(0));
            }

            Set<Character> commonNutsAndBolts = new HashSet<>();
            for(int i = 1 ; i <=nutsCnt ; i++)
            {
                char input = sc.next().charAt(0);
                if(nutsSet.contains(input))
                {
                    commonNutsAndBolts.add(input);
                }
            }
            char[] outFormat = {'!', '#' ,'$' ,'%' ,'&' ,'*' ,'@' ,'^' ,'~' };
            for(char a : outFormat)
            {
                if(commonNutsAndBolts.contains(a))
                {
                    sb.append(a).append(" ");
                }
            }
            System.out.println(sb.toString());
            System.out.println(sb.toString());
            testCases--;
        }
    }
}
