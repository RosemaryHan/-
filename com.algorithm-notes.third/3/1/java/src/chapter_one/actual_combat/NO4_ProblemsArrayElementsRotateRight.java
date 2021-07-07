package actual_combat;

import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 一个数组A中存有N（>0）个整数，在不允许使用另外数组的前提下，
 * 将每个整数循环向右移M（≥0）个位置，即将A中的数据由（A0A1···An-1)变换为变换为
 * （An-m···An-1A0A1···An-m-1)
 * （最后M个数循环移至最前面的M个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 * 输入格式:
 * 每个输入包含一个测试用例，第1行输入N（1≤N≤100）和M（≥0）；第2行输入N个整数，之间用空格分隔。
 * <p>
 * 输出格式:
 * 在一行中输出循环右移M位以后的整数序列，之间用空格分隔，序列结尾不能有多余空格。
 * <p>
 * 输入样例:
 * 6 2
 * 1 2 3 4 5 6
 * 输出样例:
 * 5 6 1 2 3 4
 * @date 2021/07/07 22:55:12
 */
public class NO4_ProblemsArrayElementsRotateRight {

    //结果如下： 部分正确（0,3,4） 内存： 15224   KB    耗时：154  ms
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            ints[i] = a;
        }
        if (m < n) {
            for (int i = n - m; i < n; i++) {
                System.out.print(ints[i] + " ");
            }
            for (int i = 0; i < n - m; i++) {
                if (i == n - m - 1) {
                    System.out.print(ints[i]);
                } else {
                    System.out.print(ints[i] + " ");
                }
            }
        } else if (m == n) {
            for (int i = ints.length - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.print(ints[i]);
                } else {
                    System.out.print(ints[i] + " ");
                }
            }
        } else {
            m = m & n;
            for (int i = 0; i < n; i++) {
                if (i == n - m - 1) {
                    System.out.print(ints[i]);
                } else {
                    System.out.print(ints[i] + " ");
                }
            }
        }
    }

    /**
     * 找不到错误点,本来以为n、m相同输出有问题添加以后不是答案错误而是格式错误。匪夷所思。
     * 1号错误点到底是啥
     */

    //结果如下： 答案正确 内存： 15092  KB    耗时：152 ms
    public static void main_2(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int cnt = in.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        in.close();

        for (int i = 0; i < cnt; i++) {
            int temp = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(" ");
            }
        }
    }

    /***
     * 就是整个移位
     */


    //他人版本 答案正确 内存： 15104   KB    耗时：170  ms
    public static void main_3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int num[] = new int[2 * N];
        for (int i = 0; i < N; i++) {
            num[i] = scanner.nextInt();
            num[N + i] = num[i];
        }

        M = M % N;

        for (int i = 0; i < N; i++) {
            System.out.print(num[N - M + i]);
            if (i == N - 1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
