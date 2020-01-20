package LeetCode.Easy.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    public static void main(String[] args) {
        int [] digits = {9,9,9};
        digits = plusOne(digits);
    }
    public static int[] plusOne(int[] digits) {

        List<Integer> sumList = new ArrayList<>();

        int carry = 1;
        int i;
        for(i = digits.length - 1 ; i >=0 ; i--)
        {
            if(digits[i] == 9)
            {
                if(carry == 1)
                {
                    sumList.add(0);
                    carry = 1;
                }
                else
                {
                    sumList.add(digits[i]);
                    carry = 0;
                }
            }
            else
            {
                if(carry == 1)
                {
                    sumList.add(digits[i] + carry);
                    carry = 0;
                }
                else
                {
                    sumList.add(digits[i]);
                }
            }
        }

        if(carry==1)
        {
            sumList.add(carry);
        }
        int[] response = new int[sumList.size()];
        int j = 0;
        for(i = sumList.size() -1 ; i >= 0; i--)
        {
            response[j++] = sumList.get(i);
        }
        return response;
    }
}
