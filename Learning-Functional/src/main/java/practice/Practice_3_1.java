package practice;

import java.util.function.BiFunction;
import java.util.stream.LongStream;

/**
 * Write a lambda expression that accepts two long arguments as a range borders and calculates (returns) product of all numbers in this range (inclusively).
 * It's guaranteed that 0 <= left border <= right border. if left border == right border then the result is any border.
 * 编写一个lambda表达式，接受两个长参数作为范围边界，并计算（返回）此范围内（包括）所有数字的乘积。 保证0 <=左边界<=右边界。 如果左边界==右边界，则结果是任何边界。
 *
 * @author zhangxin 2019-05-23 11:36:40
 */
public class Practice_3_1 {
    private static BiFunction<Long, Long, Long> mutiply = (x, y) -> LongStream.range(x, y+1).reduce(1, (m, n) -> m * n);

    public static void main(String[] args) {
        System.out.println(mutiply.apply(5L,15L));
    }
}
