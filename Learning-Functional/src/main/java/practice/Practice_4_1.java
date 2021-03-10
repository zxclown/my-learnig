package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Write a lambda expression that accepts a list of strings and returns new list of distinct strings (without repeating).
 * The order of elements in the result list may be any (elements will be sorted by the testing system).
 * If the input list doesn't contain any strings then the result list should be empty.
 *
 * 编写一个lambda表达式，接受一个字符串列表并返回不同字符串的新列表（不重复）。 结果列表中元素的顺序可以是任何元素（元素将由测试系统排序）。
 * 如果输入列表不包含任何字符串，则结果列表应为空。
 *
 * @author zhangxin 2019-05-23 15:38:18
 */
public class Practice_4_1 {
    private static Function<List<String>, List<String>> getDistinctList = (x)->x.stream().distinct().collect(Collectors.toList());

    public static void main(String[] args) {
        List<String> list = Arrays.stream("java scala java clojure clojure".split(" ")).collect(Collectors.toList());
        System.out.println(getDistinctList.apply(list));
    }
}
