package LeetCode.Recursion;


/**
 * Every number can be broken down into
 * iff Math.pow(num,x)
 *
 * and num is even then Math.pow(num,x)  can be broken as
 * Math.pow(num,x) = Math.pow(num,x/2) * Math.pow(num,x/2)
 *
 * for odd num we have
 * Math.pow(num,x) = Math.pow(num,x/2) * Math.pow(num,x/2) * num;
 *
 * here in above computation Math.pow(num,x/2) is repeated twice so we reuse this concept
 *
 * to find answer this number breaking makes the algo to go logarithmic (log(n))
 *
 */
public class MathPowerFn {

    public static void main(String[] args) {

        int n = 10;
        double response = myPow(2, 10);

        System.out.println(response);
    }

    public static double myPow(double x, int n) {

        double a;
        if (n == 0) {
            return 1;
        }
         a = myPow(x, n / 2);
        if (n % 2 == 0) {
            return a * a;
        } else {
            return  x * a * a;
        }
    }
}
