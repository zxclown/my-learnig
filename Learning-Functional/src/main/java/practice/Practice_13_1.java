package practice;

import java.util.stream.LongStream;

/**
 * Write a method using Stream API to check the input number is prime or not. Let's agree that input value is always greater than 1 (i.e. 2, 3, 4, 5, ....). Use the provided template for your method.
 * <p>
 * A prime number is a value greater than 1 that has no positive divisors other than 1 and itself. See https://en.wikipedia.org/wiki/Prime_number
 *
 * @author zhangxin 2019-06-03 13:59:40
 */
public class Practice_13_1 {

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    private static boolean isPrime(final long number) {
        // write your code here
        // range左闭右开
        return LongStream.range(2, number).noneMatch(x -> number % x == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
    }
}
