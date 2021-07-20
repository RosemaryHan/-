package actual_combat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Rosemary
 * @Description The task is really simple:
 * given N exits on a highway which forms a simple cycle,
 * you are supposed to tell the shortest distance between any pair of exits.
 * <p>
 * Input Specification:
 * Each input file contains one test case.
 * For each case, the first line contains an integer N (in [3,10^5]),
 * followed by N integer distances D1 D2````Dn
 * where Di is the distance between the i-th and the (i+1)-st exits,
 * and Dn is between the N-th and the 1st exits.
 * All the numbers in a line are separated by a space.
 * The second line gives a positive integer M (≤10^4),
 * with M lines follow, each contains a pair of exit numbers,
 * provided that the exits are numbered from 1 to N.
 * It is guaranteed that the total round trip distance is no more than 10^7
 * <p>
 * Output Specification:
 * For each test case, print your results in M lines,
 * each contains the shortest distance between the corresponding given pair of exits.
 * <p>
 * Sample Input:
 * 5 1 2 4 14 9
 * 3
 * 1 3
 * 2 5
 * 4 1
 * Sample Output:
 * 3
 * 10
 * 7
 * 作者
 * CHEN, Yue
 * 单位
 * 浙江大学
 * 代码长度限制
 * 16 KB
 * 时间限制
 * 200 ms
 * 内存限制
 * 64 MB
 * @date 2021/07/14 22:38:27
 */
public class NO8_ShortestDistance {
    //原本思路是利用链表来解决路径查询，但是链表对于JAVA来说比较慢。超时预计时。
    public static void main_1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String theWay = scanner.nextLine();
        int distance = scanner.nextInt();
        String[] loop = theWay.split(" ");
        int[] loopInt = new int[loop.length];
        for (int i = 0; i < loop.length; i++) {
            loopInt[i] = Integer.parseInt(loop[i]);
        }
    }

    //运行超时
    public static void main_2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String theHighWay = scanner.nextLine();
        //已经给出了距离，只要求编码就好了
        String[] highWayString = theHighWay.split(" ");
        int[] theWays = new int[highWayString.length + 1];
        int[] distances = new int[highWayString.length + 1];
        //算出一共有多长
        int sum = 0;
        //按照编号来
        for (int i = 1; i <= Integer.parseInt(highWayString[0]); i++) {
            theWays[i] = Integer.parseInt(highWayString[i]);
            sum += theWays[i];
            distances[i] = sum;
        }
        String s = scanner.nextLine();
        int n = Integer.parseInt(s);
        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            String[] values = value.split(" ");
            int i0 = Integer.parseInt(values[0]);
            int i1 = Integer.parseInt(values[1]);
            //从小开始取值
            if (i0 > i1) {
                int t = i0;
                i0 = i1;
                i1 = t;
            }
            //计算相隔点数
            int total = distances[i1 - 1] - distances[i0 - 1];
            int total2 = sum - total;
            System.out.println(Math.min(total, total2));
        }
    }

    //结果如下： 部分正确（最后一个点超时） 内存： 13556  KB    耗时： 110  ms
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] highWayString = reader.readLine().split(" ");
        //已经给出了距离，只要求编码就好了
        int[] theWays = new int[highWayString.length + 1];
        int[] distances = new int[highWayString.length + 1];
        //算出一共有多长
        int sum = 0;
        //按照编号来
        for (int i = 1; i <= Integer.parseInt(highWayString[0]); i++) {
            theWays[i] = Integer.parseInt(highWayString[i]);
            sum += theWays[i];
            distances[i] = sum;
        }
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String value = reader.readLine();
            String[] values = value.split(" ");
            int i0 = Integer.parseInt(values[0]);
            int i1 = Integer.parseInt(values[1]);
            //从小开始取值
            if (i0 > i1) {
                int t = i0;
                i0 = i1;
                i1 = t;
            }
            //计算相隔点数
            int total = distances[i1 - 1] - distances[i0 - 1];
            int total2 = sum - total;
            System.out.println(Math.min(total, total2));
        }
    }//再次想起为什么之前要用c刷题，痛苦面具。JAVA的运行时间真的有毒


}
