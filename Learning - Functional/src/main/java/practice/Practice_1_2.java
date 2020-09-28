package practice;

import java.util.function.Function;

/**
 * 得到传入数字最近的一个偶数.
 *
 * @author zhangxin 2019-05-23 10:23:54
 */
public class Practice_1_2 {
    private static Function<Integer, Integer> getNextEvenNumber = (x) -> x % 2 == 0 ? x + 2 : x + 1;

    public static void main(String[] args) {
        System.out.println(getNextEvenNumber.apply(4));
    }
}
