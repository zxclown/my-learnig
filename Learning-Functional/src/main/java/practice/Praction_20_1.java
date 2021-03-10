package practice;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.utils.JSONUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You have two classes:
 * <p>
 * Transaction: uuid: String,  state: State (CANCELED, FINISHED, PROCESSING), sum: Long, created: Date
 * Account: number: String, balance: Long, transactions: List<Transaction>
 * Both classes have getters for all fields with the corresponding names (getState(), getSum(), getTransactions() and so on).
 * Write a method using Stream API that calculates the total sum of canceled transactions for all non-empty accounts (balance > 0). Perhaps, flatMap method can help you to implement it.
 * <p>
 * <p>
 * Classes Transaction, Account and enum State will be available during testing. You can define your own classes for local testing.
 *
 * @author zhangxin 2019-06-26 17:19:38
 */
public class Praction_20_1 {
    static final String JSON_STR = "[\n" +
            "  {\n" +
            "    \"number\": \"1001\",\n" +
            "    \"balance\": 0,\n" +
            "    \"transactions\": [\n" +
            "      {\n" +
            "        \"uuid\": \"774cedda-9cde-4f53-8bc2-5b4d4859772a\",\n" +
            "        \"state\": \"CANCELED\",\n" +
            "        \"sum\": 1000,\n" +
            "        \"created\": \"2016-12-12 18:30:05\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"number\": \"1002\",\n" +
            "    \"balance\": 8000,\n" +
            "    \"transactions\": [\n" +
            "      {\n" +
            "        \"uuid\": \"337868a7-f469-43c0-9042-3422ce37ee26a\",\n" +
            "        \"state\": \"FINISHED\",\n" +
            "        \"sum\": 8000,\n" +
            "        \"created\": \"2016-12-12 17:30:55\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"uuid\": \"f8047f86-89e7-4226-8b75-74c55a4d7e31\",\n" +
            "        \"state\": \"CANCELED\",\n" +
            "        \"sum\": 10000,\n" +
            "        \"created\": \"2016-12-12 18:10:18\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    public static void main(String[] args) {
        List<Account> accounts = JSONUtils.parseObject(JSON_STR, new TypeReference<List<Account>>() {
        });
        System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(accounts));
    }


    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        // write your code here
        if (accounts != null && !accounts.isEmpty()) {
            return accounts.stream().filter(x -> x.getBalance() > 0)
                    .flatMap(x -> x.getTransactions().stream())
                    .filter(y -> y.getState().equals(State.CANCELED))
                    .map(y -> y.getSum())
                    .reduce(0L, (x, y) -> x + y);
        }
        return 0L;
    }


}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Transaction {
    private String uuid;
    private State state;
    private Long sum;
    private Date created;
}

enum State {
    CANCELED, FINISHED, PROCESSING;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Account {
    private String number;
    private Long balance;
    private List<Transaction> transactions;
}


