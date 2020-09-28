package practice;

import practice.function.MyFunction3;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Write a lambda expression that accepts seven (!) string arguments and returns a string in upper case concatenated from all of them (in the order of arguments).
 * 编写一个lambda表达式，接受七个字符串参数，并返回一个大写的字符串，从所有这些字符串连接起来（按参数的顺序）。
 *
 * @author zhangxin 2019-05-23 10:28:50
 */
public class Practice_2_1 {
    private static Function<String[], String> contactAndUpperCase = (strs) -> Stream.of(strs).map(String::toUpperCase).reduce("", String::concat);
    private static MyFunction3<String, String> contactAndUpperCase1 = (s1, s2, s3, s4, s5, s6, s7) -> Stream.of(s1, s2, s3, s4, s5, s6, s7).map(String::toUpperCase).reduce("", String::concat);

    public static void main(String[] args) {
        System.out.println(contactAndUpperCase.apply(new String[]{"The", "lambda", "has", "too", "many", "string", "arguments."}));
        System.out.println(contactAndUpperCase1.apply("The", "lambda", "has", "too", "many", "string", "arguments."));
    }

}


