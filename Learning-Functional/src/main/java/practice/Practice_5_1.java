package practice;

import java.util.function.DoubleFunction;

/**
 * Using closure write a lambda expression that calculates a∗x^2+b∗x+c where a, b, c are context final variables.
 * They will be available in the context during testing. Note, the result is double.
 *
 * 使用闭包写一个lambda表达式，计算 a∗x^2+b∗x+c，其中a，b，c是上下文最终变量。 它们将在测试期间在上下文中提供。 注意，结果是double类型。
 *
 * @author zhangxin 2019-05-23 17:02:59
 */
public class Practice_5_1 {
    private static double a = 2;
    private static double b = 2;
    private static double c = 2;

    private static DoubleFunction<Double> calculate = (x)->a*x*x+b*x+c;

    public static void main(String[] args) {
        System.out.println(calculate.apply(3));
    }

}
