package actual_combat;

import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 大家应该都会玩“锤子剪刀布”的游戏：两人同时给出手势，胜负规则如图所示：
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
 * <p>
 * 输入格式：
 * 输入第 1 行给出正整数 N（≤10^5），即双方交锋的次数。
 * 随后 N 行，每行给出一次交锋的信息，
 * 即甲、乙双方同时给出的的手势。C 代表“锤子”、J 代表“剪刀”、
 * B 代表“布”，第 1 个字母代表甲方，第 2 个代表乙方，
 * 中间有 1 个空格。
 * <p>
 * 输出格式：
 * 输出第 1、2 行分别给出甲、乙的胜、平、负次数，
 * 数字间以 1 个空格分隔。第 3 行给出两个字母，
 * 分别代表甲、乙获胜次数最多的手势，中间有 1 个空格。
 * 如果解不唯一，则输出按字母序最小的解。
 * <p>
 * 输入样例：
 * 10
 * C J
 * J B
 * C B
 * B B
 * B C
 * C C
 * C B
 * J B
 * B C
 * J J
 * 输出样例：
 * 5 3 2
 * 2 3 5
 * B B
 * @date 2021/07/10 23:18:05
 */
public class NO6_HammerScissorCloth {
    final static String CString = "C";
    final static String JString = "J";
    final static String BString = "B";

    //多种错误，运行超时
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //a
        int aOfTimes = 0;
        int aOfCTimes = 0;
        int aOfJTimes = 0;
        int aOfBTimes = 0;
        //b
        int bOfTimes = 0;
        int bOfCTimes = 0;
        int bOfJTimes = 0;
        int bOfBTimes = 0;
        int justNoThing = 0;
        for (int i = 0; i < n; i++) {
            //一甲二乙
            String a = scanner.next();
            String b = scanner.next();
            //平局
            if (a.equals(b)) {
                justNoThing++;
            } else if (a.equals(CString)) {
                if (b.equals(JString)) {
                    aOfTimes++;
                    aOfCTimes++;
                }
                if (b.equals(BString)) {
                    bOfTimes++;
                    bOfBTimes++;
                }
            } else if (a.equals(JString)) {
                if (b.equals(CString)) {
                    bOfTimes++;
                    bOfCTimes++;
                }
                if (b.equals(BString)) {
                    aOfTimes++;
                    aOfJTimes++;
                }
            } else if (a.equals(BString)) {
                if (b.equals(CString)) {
                    aOfTimes++;
                    aOfBTimes++;
                }
                if (b.equals(JString)) {
                    bOfTimes++;
                    bOfJTimes++;
                }
            }
        }
        System.out.println(aOfTimes + " " + (n - aOfTimes - bOfTimes) + " " + bOfTimes);
        System.out.println(bOfTimes + " " + (n - aOfTimes - bOfTimes) + " " + aOfTimes);
        String res = "";
        if (aOfBTimes > aOfJTimes && aOfBTimes > aOfCTimes) {
            res = "B ";
        } else if (aOfCTimes > aOfJTimes && aOfCTimes > aOfBTimes) {
            res = "C ";
        } else if (aOfJTimes > aOfBTimes && aOfJTimes > aOfCTimes) {
            res = "J ";
        } else {//有不同的解
            if (aOfJTimes == aOfCTimes) {
                res = "C ";
            } else if (aOfJTimes == aOfBTimes) {
                res = "B ";
            } else if (aOfCTimes == aOfBTimes) {
                res = "B ";
            }
        }
        if (bOfBTimes > bOfJTimes && bOfBTimes > bOfCTimes) {
            res = res + "B";
        } else if (bOfCTimes > bOfJTimes && bOfCTimes > bOfBTimes) {
            res = res + "C";
        } else if (bOfJTimes > bOfBTimes && bOfJTimes > bOfCTimes) {
            res = res + "J";
        } else {//有不同的解
            if (bOfJTimes == bOfCTimes) {
                res = res + "C";
            } else if (bOfJTimes == bOfBTimes) {
                res = res + "B";
            } else if (bOfCTimes == bOfBTimes) {
                res = res + "B";
            }
        }
        System.out.println(res);
    }
    /**
     * 我是不是又看漏题了····
     */
}
