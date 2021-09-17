package order.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rosemary
 * @Description PAT Ranking (25 分)
 * Programming Ability Test (PAT) is organized by the College of Computer Science and Technology of Zhejiang University.
 * Each test is supposed to run simultaneously in several places, and the ranklists will be merged immediately after the test.
 * Now it is your job to write a program to correctly merge all the ranklists and generate the final rank.
 * <p>
 * Input Specification:
 * Each input file contains one test case. For each case, the first line contains a positive number N (≤100),
 * the number of test locations. Then N ranklists follow, each starts with a line containing a positive integer K (≤300),
 * the number of testees, and then K lines containing the registration number (a 13-digit number) and the total score of each testee.
 * All the numbers in a line are separated by a space.
 * <p>
 * Output Specification:
 * For each test case, first print in one line the total number of testees.
 * Then print the final ranklist in the following format:
 * <p>
 * registration_number final_rank location_number local_rank
 * The locations are numbered from 1 to N. The output must be sorted in nondecreasing order of the final ranks.
 * The testees with the same score must have the same rank,
 * and the output must be sorted in nondecreasing order of their registration numbers.
 * <p>
 * Sample Input:
 * 2
 * 5
 * 1234567890001 95
 * 1234567890005 100
 * 1234567890003 95
 * 1234567890002 77
 * 1234567890004 85
 * 4
 * 1234567890013 65
 * 1234567890011 25
 * 1234567890014 100
 * 1234567890012 85
 * 结尾无空行
 * Sample Output:
 * 9
 * 1234567890005 1 1 1
 * 1234567890014 1 2 1
 * 1234567890001 3 1 2
 * 1234567890003 3 1 2
 * 1234567890004 5 1 4
 * 1234567890012 5 2 2
 * 1234567890002 7 1 5
 * 1234567890013 8 2 3
 * 1234567890011 9 2 4
 * @date 2021/09/13 21:54:32
 */
public class NO1_CMPOrder {

    static class Student {
        String number;
        int order;
        int score;
        int localOrder;
        int batch;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<Student> students = new ArrayList<>();
        //获取数组
        for (int i = 0; i < Integer.parseInt(s.trim()); i++) {
            String nS = scanner.nextLine();
            int n = Integer.parseInt(nS);
            for (int j = 0; j < n; j++) {
                String s1 = scanner.nextLine();
                String[] s2 = s1.split(" ");
                Student student = new Student();
                student.batch = i + 1;
                student.number = s2[0];
                student.score = Integer.parseInt(s2[1]);
                students.add(student);
            }
            ArrayList<Student> studentArrayList = new ArrayList<>();
            //排序
            for (int j = 0; j < students.size(); j++) {
                Student student = students.get(j);
                if (student.batch == i + 1) {
                    studentArrayList.add(student);
                }
            }
            for (int j = 0; j < students.size(); j++) {
                Student student = students.get(j);
                if (j > 0) {
                    Student student1 = students.get(j - 1);
                    if (student.score > student1.score) {
                        student.order = student1.order;
                        student1.order++;
                        students.set(j, student);
                        students.set(j - 1, student1);
                    } else if (student.score == student1.score) {
                        if (Long.parseLong(student.number) < Long.parseLong(student1.number)) {
                            student.order = student1.order;
                            student1.order++;
                        }else{
                            student.order++;
                        }

                        students.set(j, student);
                        students.set(j - 1, student1);
                    }
                } else {
                    student.order = 1;
                    students.set(j, student);
                }
            }
        }
        System.out.println("aaaa");

    }

}
