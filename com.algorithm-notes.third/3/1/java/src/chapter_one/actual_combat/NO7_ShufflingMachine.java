package actual_combat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rosemary
 * @Description Shuffling is a procedure used to randomize a deck of playing cards.
 * Because standard shuffling techniques are seen as weak,
 * and in order to avoid "inside jobs" where employees collaborate
 * with gamblers by performing inadequate shuffles,
 * many casinos employ automatic shuffling machines.
 * Your task is to simulate a shuffling machine.
 * <p>
 * The machine shuffles a deck of 54 cards according to a given random order
 * and repeats for a given number of times.
 * It is assumed that the initial status of a card deck is in the following order:
 * <p>
 * S1, S2, ..., S13,
 * H1, H2, ..., H13,
 * C1, C2, ..., C13,
 * D1, D2, ..., D13,
 * J1, J2
 * where "S" stands for "Spade", "H" for "Heart", "C" for "Club", "D" for "Diamond",
 * and "J" for "Joker".
 * A given order is a permutation of distinct integers in [1, 54].
 * If the number at the i-th position is j,
 * it means to move the card from position i to position j.
 * For example, suppose we only have 5 cards: S3, H5, C1, D13 and J2.
 * Given a shuffling order {4, 2, 5, 3, 1},
 * the result will be: J2, H5, D13, S3, C1.
 * If we are to repeat the shuffling again,
 * the result will be: C1, H5, S3, J2, D13.
 * <p>
 * Input Specification:
 * Each input file contains one test case.
 * For each case, the first line contains a positive integer K (≤20)
 * which is the number of repeat times.
 * Then the next line contains the given order.
 * All the numbers in a line are separated by a space.
 * <p>
 * Output Specification:
 * For each test case, print the shuffling results in one line.
 * All the cards are separated by a space,
 * and there must be no extra space at the end of the line.
 * <p>
 * Sample Input:
 * 2
 * 36 52 37 38 3 39 40 53 54 41 11 12 13 42 43 44 2 4 23 24 25 26 27 6 7 8 48 49 50 51 9 10 14 15 16 5 17 18 19 1 20 21 22 28 29 30 31 32 33 34 35 45 46 47
 * Sample Output:
 * S7 C11 C10 C12 S1 H7 H8 H9 D8 D9 S11 S12 S13 D10 D11 D12 S3 S4 S6 S10 H1 H2 C13 D2 D3 D4 H6 H3 D13 J1 J2 C1 C2 C3 C4 D1 S5 H5 H11 H12 C6 C7 C8 C9 S2 S8 S9 H10 D5 D6 D7 H4 H13 C5
 * 作者
 * CHEN, Yue
 * 单位
 * 浙江大学
 * 代码长度限制
 * 16 KB
 * 时间限制
 * 400 ms
 * 内存限制
 * 64 MB
 * @date 2021/07/12 23:49:22
 */
public class NO7_ShufflingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String[] cards = new String[55];
        int[] rules = new int[55];
        //获取到牌组
        for (int i = 0; i < 52; i++) {
            if (i < 13 && i >= 0) {
                cards[i] = "S" + (i + 1);
            }
            if (i < 26 && i >= 13) {
                cards[i] = "H" + (((i) % 13) + 1);
            }
            if (i < 39 && i >= 26) {
                cards[i] = "C" + (((i) % 13) + 1);
            }
            if (i < 53 && i >= 39) {
                cards[i] = "D" + (((i) % 13) + 1);
            }
        }
        cards[53] = "J1";
        cards[54] = "J2";

        //循环获取规则
        for (int i = 0; i < 54; i++) {
            rules[i] = scanner.nextInt();
        }
    }

    public static void main_2(String[] args) throws IOException {
        int n = 54;
        char[] ch = { 'S', 'H', 'C', 'D' };
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                StringBuilder bd = new StringBuilder();
                bd.append(ch[i]);
                bd.append(j);
                list.add(bd.toString());
            }
            if (i == 3) {
                list.add("J1");
                list.add("J2");
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] num = new int[60];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        int[] start = new int[55];
        int[] end = new int[55];
        for (int i = 0; i < n; i++) {
            start[i] = i;
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                end[num[j] - 1] = start[j];
            }
            for (int j = 0; j < n; j++) {
                start[j] = end[j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(list.get(start[i]));

        }
        System.out.println();
    }
}
