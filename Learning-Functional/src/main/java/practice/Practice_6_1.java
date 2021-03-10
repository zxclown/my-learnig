package practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You have a class Account (number: String, balance: Long, isLocked: boolean), the list accounts of type List<Account> and the method filter(List<T> elems, Predicate<T> predicate) for filtering the given list of type T by the predicate.
 * The class Account has the next methods: getNumber(), getBalance(), isLocked() for getting the values of the corresponding fields.
 * Write a code for filtering the accounts list in two ways:
 * 1.get list with all non-empty accounts (balance > 0) and save it to the variable nonEmptyAccounts
 * 2.get all non-locked accounts with too much money (balance >= 100 000 000) and save it to the variable accountsWithTooMuchMoney
 *
 * @author zhangxin 2019-06-03 10:10:10
 */
public class Practice_6_1 {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("AAA", 100000001L, false));
        accounts.add(new Account("BBB", 90000001L, false));
        accounts.add(new Account("CCC", 190000001L, false));
        accounts.add(new Account("DDD", 180000001L, true));
        accounts.add(new Account("EEE", -80000001L, false));
        accounts.add(new Account("FFF", 70000001L, false));
        accounts.add(new Account("GGG", 110000001L, false));
        accounts.add(new Account("HHH", 70000001L, false));
        accounts.add(new Account("III", 90000001L, true));

        List<Account> nonEmptyAccounts = accounts.stream().filter(x -> x.getBalance() > 0).collect(Collectors.toList());
        List<Account> accountsWithTooMuchMoney = accounts.stream().filter(x -> x.getBalance() >= 100000000L && !x.isLocked)
                .collect(Collectors.toList());
        System.out.println(nonEmptyAccounts);
        System.out.println(accountsWithTooMuchMoney);
    }

    @Data
    @AllArgsConstructor
    private static class Account {
        private String number;
        private Long balance;
        private boolean isLocked;
    }

}
