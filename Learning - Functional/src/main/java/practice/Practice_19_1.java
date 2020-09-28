package practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.util.List;

/**
 * You have two classes: Employee (name: String, salary: Long) and Department (name: String, code: String, employees: List<Employee>).
 * Both classes have getters for all fields with the corresponding names (getName(), getSalary(), getEmployees() and so on).
 * <p>
 * Write a method using Stream API that calculates the general number of employees with salary >= threshold for all departments
 * whose code starts with string "111-" (without ""). Perhaps, flatMap method can help you to implement it.
 * <p>
 * Classes Employee and Department will be available during testing. You can define your own classes for local testing.
 *
 * @author zhangxin 2019-06-11 17:33:46
 */
public class Practice_19_1 {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final String JSON_STRING = "[\n" +
            "  {\n" +
            "    \"name\": \"dep-1\",\n" +
            "    \"code\": \"111-1\",\n" +
            "    \"employees\": [\n" +
            "      {\n" +
            "        \"name\": \"William\",\n" +
            "        \"salary\": 20000\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Sophia\",\n" +
            "        \"salary\": 10000\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dep-2\",\n" +
            "    \"code\": \"222-1\",\n" +
            "    \"employees\": [\n" +
            "      {\n" +
            "        \"name\": \"John\",\n" +
            "        \"salary\": 50000\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    public static void main(String[] args) {
        try {
            List<Department> departments = OBJECT_MAPPER.readValue(JSON_STRING, new TypeReference<List<Department>>() {
            });
            System.out.println(calcNumberOfEmployees(departments, 20000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold   is lower edge of salary
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream().filter(x -> x.getCode().startsWith("111-"))
                .flatMap(x -> x.getEmployees().stream()).filter(y -> y.getSalary() >= threshold).count();
    }

    @Data
    public static class Employee {
        private String name;
        private Long salary;
    }

    @Data
    public static class Department {
        private String name;
        private String code;
        private List<Employee> employees;
    }
}
