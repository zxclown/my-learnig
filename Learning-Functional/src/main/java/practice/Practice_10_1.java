package practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

/**
 * Let's assume there is class Student exists. Each student has a name and a grade for exam in computer science.
 *
 * You need to understand in what order the list will be sorted by the code below.
 *
 * @author zhangxin 2019-06-03 11:16:13
 */
public class Practice_10_1 {
    @Data
    @AllArgsConstructor
    private static class Student{
        private String name;
        private int csGrade;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John",100));
        students.add(new Student("Elizabet",97));
        students.add(new Student("Antonio",85));
        students.add(new Student("Alisa",100));
        students.add(new Student("Mary",82));
        students.add(new Student("Vladimir",94));
        students.add(new Student("Francis",85));

        students.sort(
                comparing(Student::getCsGrade, reverseOrder())
                        .thenComparing(Student::getName));
        System.out.println(students);
    }

}
