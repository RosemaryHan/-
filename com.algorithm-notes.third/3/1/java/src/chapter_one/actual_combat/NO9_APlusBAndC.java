package actual_combat;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Rosemary
 * @Description Given three integers A, B and C in [−2^63,2^63],
 * you are supposed to tell whether A+B>C.
 * <p>
 * Input Specification:
 * The first line of the input gives the positive number of test cases, T (≤10).
 * Then T test cases follow,
 * each consists of a single line containing three integers A, B and C, separated by single spaces.
 * <p>
 * Output Specification:
 * For each test case, output in one line Case #X: true if A+B>C,
 * or Case #X: false otherwise, where X is the case number (starting from 1).
 * <p>
 * Sample Input:
 * 3
 * 1 2 3
 * 2 3 4
 * 9223372036854775807 -9223372036854775808 0
 * Sample Output:
 * Case #1: false
 * Case #2: true
 * Case #3: false
 * @date 2021/07/21 22:34:34
 */
public class NO9_APlusBAndC {

    //结果如下： 部分正确（最后两个点错误） 内存： 15148   KB    耗时： 146   ms
    public static void main_1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String values = scanner.nextLine();
            String[] valueString = values.split(" ");
            long numberOne = Long.parseLong(valueString[0]);
            long numberTwo = Long.parseLong(valueString[1]);
            long numberThree = Long.parseLong(valueString[2]);
            if (numberOne + numberTwo > numberThree) {
                System.out.println("Case #" + (i + 1) + ": true");
            } else {
                System.out.println("Case #" + (i + 1) + ": false");
            }
        }
    }

    //结果如下： 部分正确（最后一个点错误） 内存： 14832   KB    耗时： 126   ms
    public static void main_2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String values = scanner.nextLine();
            String[] valueString = values.split(" ");
            long numberOne = Long.parseLong(valueString[0]);
            long numberTwo = Long.parseLong(valueString[1]);
            long numberThree = Long.parseLong(valueString[2]);
            long res = numberOne + numberTwo;
            boolean flag = true;
            //负数溢出
            if (numberOne > 0 && numberTwo > 0 && res <= 0) {
                flag = true;
            } else if (numberOne < 0 && numberTwo < 0 && res >= 0) {
                flag = false;
            } else if (res > numberThree) {
                flag = true;
            } else {
                flag = false;
            }
            if (flag) {
                System.out.println("Case #" + (i + 1) + ": true");
            } else {
                System.out.println("Case #" + (i + 1) + ": false");
            }
        }
    }

    //实在找不到错，但是同样写法C++没有报错，就离谱--推测是精度问题
    public static void main_3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                String values = scanner.nextLine();
                String[] valueString = values.split(" ");
                long numberOne = Long.parseLong(valueString[0]);
                long numberTwo = Long.parseLong(valueString[1]);
                long numberThree = Long.parseLong(valueString[2]);
                long res = numberOne + numberTwo;
                boolean flag = true;
                //负数溢出
                if (numberOne > 0 && numberTwo > 0 && res <= 0) {
                    flag = true;
                } else if (numberOne < 0 && numberTwo < 0 && res >= 0) {
                    flag = false;
                } else if (res > numberThree) {
                    flag = true;
                } else {
                    flag = false;
                }
                if (flag) {
                    System.out.println("Case #" + (i + 1) + ": true");
                } else {
                    System.out.println("Case #" + (i + 1) + ": false");
                }
            }
        }
    }

    //结果如下： 全部正确 内存： 15324    KB    耗时： 140    ms
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                String values = scanner.nextLine();
                String[] valueString = values.split(" ");

                BigInteger numberOne = new BigInteger(valueString[0]);
                BigInteger numberTwo = new BigInteger(valueString[1]);
                BigInteger numberThree = new BigInteger(valueString[2]);
                BigInteger res = numberOne.add(numberTwo);
                boolean flag = true;
                //负数溢出
                if (numberOne.compareTo(new BigInteger("0")) > 0 &&
                        numberTwo.compareTo(new BigInteger("0")) > 0 &&
                        res.compareTo(new BigInteger("0")) <= 0) {
                    flag = true;
                } else if (numberOne.compareTo(new BigInteger("0"))  < 0 &&
                        numberTwo.compareTo(new BigInteger("0"))  < 0 &&
                        res.compareTo(new BigInteger("0")) >= 0) {
                    flag = false;
                } else if (res .compareTo(numberThree)>0 ) {
                    flag = true;
                } else {
                    flag = false;
                }
                if (flag) {
                    System.out.println("Case #" + (i + 1) + ": true");
                } else {
                    System.out.println("Case #" + (i + 1) + ": false");
                }
            }
        }
    }
//他人版本

    /**
     * @Auther: Xingzheng Wang
     * @Date: 2019/2/26 9:59
     * @Description: pattest
     * @Version: 1.0
     */
    public static void mainOthers(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            BigInteger a, b, c;
            a = sc.nextBigInteger();
            b = sc.nextBigInteger();
            c = sc.nextBigInteger();
            if ((a.add(b).compareTo(c)) > 0) {
                System.out.println("Case #" + i + ": true");
            } else {
                System.out.println("Case #" + i + ": false");
            }
        }
    }

}
