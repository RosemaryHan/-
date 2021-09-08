import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统。
 * 2014 年底，为庆祝“计算机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。
 * 现在你也跟他一起画吧！
 * <p>
 * 输入格式：
 * 输入在一行中给出正方形边长 N（3≤N≤20）和组成正方形边的某种字符 C，间隔一个空格。
 * <p>
 * 输出格式：
 * 输出由给定字符 C 画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的 50%（四舍五入取整）。
 * <p>
 * 输入样例：
 * 10 a
 * 结尾无空行
 * 输出样例：
 * aaaaaaaaaa
 * a        a
 * a        a
 * a        a
 * aaaaaaaaaa
 * 结尾无空行
 * @date 2021/09/08 10:38:28
 */

public class NO2_ProgrammingWithObama {

    //  结果如下：部分正确 1、2错误 内存： 15676  KB    耗时：258 ms
    public static void main_1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = Math.round(n / 2);

        String s = scanner.nextLine();
        for (int i = 0; i < a; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print(s.trim());
                }
                System.out.println();
            } else if (i == (a) - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print(s.trim());
                }
                System.out.println();
            } else {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        System.out.print(s.trim());
                    } else if (j == (n - 1)) {
                        System.out.print(s.trim());
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    // 结果如下： 全部正确 内存：15156 KB   耗时：163 ms
    public static void main_2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //前一个错误原因是在于当a==1时除整数2直接为0，需要通过浮点数获取原值再进行四舍五入
        int a = (int) Math.round(n / 2.0);

        String s = scanner.nextLine();
        s = s.trim();
        for (int i = 0; i < a; i++) {
            //第一行和最后一行
            if (i == 0 || i == a - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print(s);
                }
                System.out.println();
            } else {
                //中间行数
                for (int j = 0; j < n; j++) {
                    if (j == 0 || j == (n - 1)) {
                        System.out.print(s);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    //  结果如下：全部正确 内存： 14548 KB    耗时：236 ms
    public static void main_3(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String C = s.next();
        int column = (int) Math.round(N / 2.0);
        for (int i = 0; i < column; i++) { // 行
            for (int j = 0; j < N; j++) { // 列
                if (i == 0 || i == column - 1) {
                    System.out.print(C);
                } else {
                    if (j == 0 || j == N - 1) {
                        System.out.print(C);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    //  结果如下：全部正确 内存： 15292  KB    耗时：204  ms
    public static void main_4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.nextLine();
        //四舍五入
        int a = n % 2 == 0 ? n / 2 : (n / 2) + 1;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == a - 1) {
                    System.out.print(s.trim());
                } else {
                    if (j == 0 || j == n - 1) {
                        System.out.print(s.trim());
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
