package practice;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You have two IntStream. The first stream contains even numbers and the second stream contains odd numbers.
 * Create the third stream that contains numbers from both streams which is divisible by 3 and 5.
 * After calling collect(Collectors.toList()) the stream should return sorted list (ascending) of these numbers.
 * Two first suitable numbers in the sorted list must be skipped.
 *
 * @author zhangxin 2019-06-10 16:02:48
 */
public class Practice_15_1 {
    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        // write your stream here
        return IntStream.concat(evenStream, oddStream).filter(x -> x % 3 == 0 && x % 5 == 0).sorted().skip(2);
    }

    public static void main(String[] args) {
        IntStream evenStream = Arrays.stream(new int[]{1, 3, 5, 35, 75});
        IntStream oddStream = Arrays.stream(new int[]{2, 4, 30, 60, 90});
        IntStream filteringStream = createFilteringStream(evenStream, oddStream);
        filteringStream.forEach(System.out::println);
    }
}
