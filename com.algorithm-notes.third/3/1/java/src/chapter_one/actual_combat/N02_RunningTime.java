package actual_combat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 要获得一个 C 语言程序的运行时间，常用的方法是调用头文件 time.h，
 * 其中提供了 clock() 函数，可以捕捉从程序开始运行到 clock() 被调用时所耗费的时间。
 * 这个时间单位是 clock tick，即“时钟打点”。同时还有一个常数 CLK_TCK，
 * 给出了机器时钟每秒所走的时钟打点数。于是为了获得一个函数  的运行时间，
 * 我们只要在调用 f 之前先调用 clock()，获得一个时钟打点数 C1；
 * 在 f 执行完成后再调用 clock()，获得另一个时钟打点数 C2；
 * 两次获得的时钟打点数之差 (C2-C1) 就是 f 运行所消耗的时钟打点数，
 * 再除以常数 CLK_TCK，就得到了以秒为单位的运行时间。
 *
 * 这里不妨简单假设常数 CLK_TCK 为 100。
 * 现给定被测函数前后两次获得的时钟打点数，请你给出被测函数运行的时间。
 *
 * 输入格式：
 * 输入在一行中顺序给出 2 个整数 C1 和 C2。注意两次获得的时钟打点数肯定不相同，
 * 即 C1 < C2，并且取值在[0,10^7] 。
 *
 * 输出格式：
 * 在一行中输出被测函数运行的时间。
 * 运行时间必须按照 hh:mm:ss（即2位的 时:分:秒）格式输出；
 * 不足 1 秒的时间四舍五入到秒。
 *
 * 输入样例：
 * 123 4577973
 *
 * 输出样例：
 * 12:42:59
 * @date 2021/07/05 22:55:57
 */
public class N02_RunningTime {

    //结果如下： 内存： 15580 KB    耗时：134 ms
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        //运行时间
        double time = ((c2 - c1) * 1.0) / 100;
        //求得时间
        int hh = (int) time / 3600;
        int mm = (int) time % 3600 / 60;
        double  s = time - hh * 3600 - mm * 60;
        //四舍五入
        int ss = (int)Math.round(s);
        System.out.printf("%02d:%02d:%02d\n",hh,mm,ss);
    }
    }


