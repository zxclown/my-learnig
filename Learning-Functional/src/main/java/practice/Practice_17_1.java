package practice;

import java.util.stream.LongStream;

/**
 * Write a method for calculating the sum of odd numbers in the given interval (inclusively) using Stream API.
 *
 * @author zhangxin 2019-06-10 18:09:37
 */
public class Practice_17_1 {

    /**
     * The method calculates the sum of odd numbers in the given range
     *
     * @param start of a range, start >= 0
     * @param end   of a range (inclusive), end >= start
     * @return sum of odd numbers
     */
    public static long sumOfOddNumbersInRange(long start, long end) {
        // write your code here
        return LongStream.rangeClosed(start, end).filter(x -> x % 2 == 1).reduce(0, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(sumOfOddNumbersInRange(0,0));
        System.out.println(sumOfOddNumbersInRange(7,9));
        System.out.println(sumOfOddNumbersInRange(21,30));
    }
}
