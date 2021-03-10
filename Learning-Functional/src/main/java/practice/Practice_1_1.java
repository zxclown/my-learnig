package practice;

import java.util.function.BiFunction;

/**
 * The type Lesson 1.
 *
 * @author zhangxin 2019-05-23 10:09:20
 */
public class Practice_1_1 {
    private static BiFunction<Integer, Integer, Integer> getMax = (x, y) -> x > y ? x : y;

    /**
     * 传入两个数，返回最大值.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(getMax.apply(1,4));
    }
}
