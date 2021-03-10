package practice;

import java.util.stream.LongStream;

/**
 * What does this code print?
 *
 * @author zhangxin 2019-06-03 13:41:31
 */
public class Practice_12_1 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        boolean result = LongStream
                .rangeClosed(1, 100_000)
                .anyMatch(val -> val == 100_000);

        System.out.println(result);
    }
}
