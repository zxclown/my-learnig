package practice;

import java.util.function.IntUnaryOperator;

/**
 * The type Practice 8 1.
 *
 * @author zhangxin 2019-06-03 10:36:26
 */
public class Practice_8_1 {
    public static void main(String[] args) {
        IntUnaryOperator mult2 = num -> num * 2;
        IntUnaryOperator add3 = num -> num + 3;

        IntUnaryOperator combinedOperator = add3.compose(mult2.andThen(add3)).andThen(mult2);
        int result = combinedOperator.applyAsInt(5);
        // 最终结果？
        System.out.println(result);
    }
}
