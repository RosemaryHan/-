package actual_combat;

import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 划拳是古老中国酒文化的一个有趣的组成部分。
 * 酒桌上两人划拳的方法为：每人口中喊出一个数字，同时用手比划出一个数字。
 * 如果谁比划出的数字正好等于两人喊出的数字之和，谁就赢了，输家罚一杯酒。
 * 两人同赢或两人同输则继续下一轮，直到唯一的赢家出现。
 * <p>
 * 下面给出甲、乙两人的划拳记录，请你统计他们最后分别喝了多少杯酒。
 * <p>
 * 输入格式：
 * <p>
 * 输入第一行先给出一个正整数N（<=100），随后N行，每行给出一轮划拳的记录，格式为：
 * <p>
 * 甲喊 甲划 乙喊 乙划
 * <p>
 * 其中“喊”是喊出的数字，“划”是划出的数字，均为不超过100的正整数（两只手一起划）。
 * <p>
 * 输出格式：
 * <p>
 * 在一行中先后输出甲、乙两人喝酒的杯数，其间以一个空格分隔。
 * <p>
 * 输入样例：
 * <p>
 * 5
 * 8 10 9 12
 * 5 10 5 10
 * 3 8 5 12
 * 12 18 1 13
 * 4 16 12 15
 * 输出样例：
 * <p>
 * 1 2
 * @date 2021/07/05 23:37:57
 */
public class N03_Rowing {

    //结果如下： 部分正确 内存： 16336KB    耗时：191ms
    public static void main_1(String[] args) {
        int timesOfA = 0;
        int timesOfB = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int speakOfA = scanner.nextInt();
            int numberOfA = scanner.nextInt();
            int speakOfB = scanner.nextInt();
            int numberOfB = scanner.nextInt();
            int total = numberOfA + numberOfB;
            if (total == speakOfA &&
                    total == speakOfB) {
                continue;
            } else if (speakOfA != total && speakOfB != total) {
                continue;
            }
            if (total == speakOfA) {
                timesOfA++;
            } else if (total == speakOfB) {
                timesOfB++;
            }
        }
        System.out.println(timesOfA+" "+timesOfB);
    }
    //还是部分正确   我靠了，谢谢我自己 喊等于划，加喊=划
    public static void main_2(String[] args) {
        int timesOfA = 0;
        int timesOfB = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int speakOfA = scanner.nextInt();
            int numberOfA = scanner.nextInt();
            int speakOfB = scanner.nextInt();
            int numberOfB = scanner.nextInt();

            int total = numberOfA + numberOfB;
            if (total == speakOfA
            &&total!=speakOfB) {
                timesOfB++;
            } else if (total == speakOfB
                    &&total!=speakOfA) {
                timesOfA++;
            }
        }
        System.out.println(timesOfA+" "+timesOfB);
    }

    //结果如下： ac 内存： 16172 KB    耗时：164
    public static void main(String[] args) {
        int timesOfA = 0;
        int timesOfB = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int speakOfA = scanner.nextInt();
            int numberOfA = scanner.nextInt();
            int speakOfB = scanner.nextInt();
            int numberOfB = scanner.nextInt();

            int total = speakOfA + speakOfB;
            if (total == numberOfA
                    &&total!=numberOfB) {
                timesOfB++;
            } else if (total == numberOfB
                    &&total!=numberOfA) {
                timesOfA++;
            }
        }
        System.out.println(timesOfA+" "+timesOfB);
    }
}


