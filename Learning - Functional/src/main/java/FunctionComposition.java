import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class FunctionComposition {
    public static void main(String[] args) {
//        Function<Integer, Integer> adder = x -> x + 10;
//        Function<Integer, Integer> multiplier = x -> x * 5;
//
//        // compose: adder(multiplier(5))
//        System.out.println("result: " + adder.compose(multiplier).apply(5));
//
//        // andThen: multiplier(adder(5))
//        System.out.println("result: " + adder.andThen(multiplier).apply(5));

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
        IntPredicate isEven = x -> x % 2 == 0;
        IntPredicate dividedBy3 = x -> x % 3 == 0;
        IntPredicate pred = isEven.negate().or(dividedBy3);

        // print all odd values and even values that can be divided by 3.
        numbers.forEach(val -> {
            if (pred.test(val)) {
                System.out.print(val + " ");
            }
        });

        // sum of two identities: 0 + 10 = 10
        long sumOfIdentities = sumF(x -> x).applyAsInt(0, 10);
    }

    public static IntBinaryOperator sumF(IntUnaryOperator f) {
        return (a, b) -> f.applyAsInt(a) + f.applyAsInt(b);
    }
}
