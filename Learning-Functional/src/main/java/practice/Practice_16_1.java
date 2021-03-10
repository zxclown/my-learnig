package practice;

import java.util.stream.LongStream;

/**
 * The factorial of n is calculated by the product of integer number from 1 to n (inclusive). The factorial of 0 is equal to 1.
 *
 * @author zhangxin 2019-06-10 17:56:18
 */
public class Practice_16_1 {
    /**
     * Calculates the factorial of the given number n
     *
     * @param n >= 0
     *
     * @return factorial value
     */
    public static long factorial(long n) {
        // write your code here
        return LongStream.rangeClosed(1L,n).reduce(1L,(x,y)->x*y);
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }
}
