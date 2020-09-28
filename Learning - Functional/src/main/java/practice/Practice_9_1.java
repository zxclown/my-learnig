package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * Write the disjunctAll method that accepts a list of IntPredicate's and returns a single IntPredicate.
 * The result predicate is a disjunction(析取) of all input predicates.
 *
 * If the input list is empty then the result predicate should return false for any integer value (always false).
 *
 * @author zhangxin 2019-06-03 10:43:08
 */
public class Practice_9_1 {
    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    private static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        IntPredicate intPredicate = value -> false;
        return predicates.stream().reduce(intPredicate, IntPredicate::or);
    }

    public static void main(String[] args) {
        System.out.println(disjunctAll(new ArrayList<>()));
    }
}
