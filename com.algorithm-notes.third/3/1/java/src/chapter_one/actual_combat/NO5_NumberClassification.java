package actual_combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
 * <p>
 * A1  = 能被 5 整除的数字中所有偶数的和；
 * A2 = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1-n2+n3-n4````
 * A3= 被 5 除后余 2 的数字的个数；
 * A4 = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
 * A5= 被 5 除后余 4 的数字中最大数字。
 * 输入格式：
 * 每个输入包含 1 个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。数字间以空格分隔。
 * <p>
 * 输出格式：
 * 对给定的 N 个正整数，按题目要求计算 A1~A5
 * 并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * <p>
 * 若其中某一类数字不存在，则在相应位置输出 N。
 * <p>
 * 输入样例 1：
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 * 输出样例 1：
 * 30 11 2 9.7 9
 * 输入样例 2：
 * 8 1 2 4 5 6 7 9 16
 * 输出样例 2：
 * N 11 2 N 9
 * @date 2021/07/08 22:17:40
 */
public class NO5_NumberClassification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        int A4 = 0;
        int A5 = -1;
        int A4Sum = 0;
        List<Integer> A2s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if (n % 2 == 0 && n % 5 == 0) {
                A1 = A1 + number;
                continue;
            }
            if (n % 5 == 1) {
                A2s.add(n);
                continue;
            }
            if (n % 5 == 2) {
                A3++;
                continue;
            }
            if (n % 5 == 3) {
                A3++;
                A4Sum = A4Sum + number;
                continue;
            }
            if (n % 5 == 4) {
                if (number > A5) {
                    A5 = number;
                    continue;
                }
            }
        }
        //计算A2
        for (int i = 0; i < A2s.size(); i++) {
            if (i % 2 == 0) {
                A2 = A2 + A2s.get(i);
            } else {
                A2 = A2 - A2s.get(i);
            }
        }
        System.out.println(A1);
    }
}
