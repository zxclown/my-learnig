package practice;

import java.util.function.Function;

/**
 * Using closure write a lambda expression that adds prefix (before) and suffix (after) to its single string argument;
 * prefix and suffix are final variables and will be available in the context during testing.
 * All whitespaces on the both ends of the argument must be removed. Do not trim prefix, suffix and the result string.
 *
 * 使用闭包写一个lambda表达式，在其单个字符串参数中添加前缀（before）和后缀（after）; 前缀和后缀是最终变量，在测试期间将在上下文中可用。
 * 必须删除参数两端的所有空格。 不要修剪前缀，后缀和结果字符串。
 * @author zhangxin 2019-05-23 17:31:23
 */
public class Practice_5_2 {
    private static String prefix = "prefix";
    private static String suffix = "suffix";
    private static Function<String,String> contact = x-> prefix + x.trim() + suffix;

    public static void main(String[] args) {
        System.out.println(contact.apply("xxx"));
    }
}
