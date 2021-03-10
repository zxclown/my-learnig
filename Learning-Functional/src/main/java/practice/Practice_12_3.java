package practice;

import java.util.stream.IntStream;

/**
 * What does this code print?
 *
 * @author zhangxin 2019-06-03 13:52:35
 */
public class Practice_12_3 {
    public static void main(String[] args) {
        boolean result = IntStream
                .iterate(0, n -> n + 1)
                .limit(100)
                .filter(n -> n % 2 != 0)
                .noneMatch(n -> n % 2 == 0);

        System.out.println(result);
    }
}
