package actual_combat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rosemary
 * @Description 给定区间[-231, 231]内的3个整数A、B和C，请判断A+B是否大于C。
 * 输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。
 * 整数间以空格分隔。
 * <p>
 * 对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，
 * 其中X是测试用例的编号（从1开始）。
 * <p>
 * 4
 * 1 2 3
 * 2 3 4
 * 2147483647 0 2147483646
 * 0 -2147483648 -2147483647
 * <p>
 * Case #1: false
 * Case #2: true
 * Case #3: true
 * Case #4: false
 * @date 2021/07/01 23:05:57
 */
public class N01_APlusBAndC {

    //结果如下： 内存： 16336KB    耗时：175ms
    public static void main_1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        int n = Integer.parseInt(readLine);
        String[] res = new String[n + 2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] numbers = s.split(" ");
            Long a = Long.parseLong(numbers[0]);
            Long b = Long.parseLong(numbers[1]);
            Long c = Long.parseLong(numbers[2]);
            if (a + b > c) {
                res[i] = "true";
            } else {
                res[i] = "false";
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Case #" + (i + 1) + ": " + res[i]);
        }
    }

    //结果如下： 内存： 14528KB    耗时：120ms
    public static void main_2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        int n = Integer.parseInt(readLine);
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] numbers = s.split(" ");
            Long a = Long.parseLong(numbers[0]);
            Long b = Long.parseLong(numbers[1]);
            Long c = Long.parseLong(numbers[2]);
            //上一个版本较为死脑筋，没有注意到这个输出规则是可以直接在循环里面解决的，小改动大进步，笑死
            if (a + b > c) {
                System.out.println("Case #" + (i + 1) + ": true");
            } else {
                System.out.println("Case #" + (i + 1) + ": false");
            }
        }

    }

    //结果如下： 内存： 14572 KB    耗时：130ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        int n = Integer.parseInt(readLine);
        int step = 1;
        while (n != 0) {
            String s = br.readLine();
            String[] numbers = s.split(" ");
            Long a = Long.parseLong(numbers[0]);
            Long b = Long.parseLong(numbers[1]);
            Long c = Long.parseLong(numbers[2]);
            //上一个版本较为死脑筋，没有注意到这个输出规则是可以直接在循环里面解决的，小改动大进步，笑死
            if (a + b > c) {
                System.out.println("Case #" + step + ": true");
            } else {
                System.out.println("Case #" + step + ": false");
            }
            step++;
            n--;
        }
    }

    /**
     * 最后总结：此题坑点有一个，就是int的范围是[-2^31,2^31-1]如果用int会报错
     */
}
