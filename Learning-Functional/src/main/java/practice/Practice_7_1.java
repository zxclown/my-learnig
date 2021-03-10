package practice;

/**
 * You need to write your own functional interface (TernaryIntPredicate) and use it with a lambda expression.
 * The interface must have a single non-static (and non-default) method test with three int arguments that returns boolean value.
 * <p>
 * Besides, you need to write a lambda expression with three int arguments using your TernaryIntPredicate.
 * <p>
 * The lambda expression has to return true if all passed values are different otherwise false.
 * The name of the instance is allValuesAreDifferentPredicate. It should be a static field.
 *
 * @author zhangxin 2019-06-03 10:31:01
 */
public class Practice_7_1 {
    @FunctionalInterface
    private interface TernaryIntPredicate {
        boolean test(int a, int b, int c);
    }

    private static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) -> {
        return a != b && a != c && b != c;
    };

    public static void main(String[] args) {
        System.out.println(allValuesAreDifferentPredicate.test(2, 3, 4));
        System.out.println(allValuesAreDifferentPredicate.test(1, 1, 1));
    }
}
