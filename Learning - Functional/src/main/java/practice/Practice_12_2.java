package practice;

import java.util.stream.IntStream;

/**
 * What does this code print?
 *
 * @author zhangxin 2019-06-03 13:40:58
 */
public class Practice_12_2 {
    public static void main(String[] args) {
        boolean result = !IntStream
                // ()->100 生成的都是100
                .generate(() -> 100)
                // 限制个数
                .limit(101)
                .allMatch(val -> val >= 100);
        System.out.println(result);
    }
}
