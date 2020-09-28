package practice;

import java.util.function.Consumer;

/**
 * The type Practice 8 2.
 *
 * @author zhangxin 2019-06-03 10:37:30
 */
public class Practice_8_2 {
    public static void main(String[] args) {
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> devNull = (val) -> { int v = val * 2; };

        Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
        combinedConsumer.accept(100);
        // 最终结果？
        System.out.println(combinedConsumer);
    }
}
