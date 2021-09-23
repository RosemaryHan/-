import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rosemary
 * @Description 给定数字 0-9 各若干个。你可以以任意顺序排列这些数字，但必须全部使用。
 * 目标是使得最后得到的数尽可能小（注意 0 不能做首位）。
 * 例如：给定两个 0，两个 1，三个 5，一个 8，我们得到的最小的数就是 10015558。
 * <p>
 * 现给定数字，请编写程序输出能够组成的最小的数。
 * <p>
 * 输入格式：
 * 输入在一行中给出 10 个非负整数，顺序表示我们拥有数字 0、数字 1、……数字 9 的个数。
 * 整数间用一个空格分隔。
 * 10 个数字的总个数不超过 50，且至少拥有 1 个非 0 的数字。
 * <p>
 * 输出格式：
 * 在一行中输出能够组成的最小的数。
 * <p>
 * 输入样例：
 * 2 2 0 0 0 3 0 0 1 0
 * 结尾无空行
 * 输出样例：
 * 10015558
 * @date 2021/09/23 21:38:38
 */
public class NO2_MakeAMinNumber {

    //结果： 全部正确    耗时： 105 ms          内存：13792 KB
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        String[] numbers = readLine.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int min = 10;
        for (int i = 1; i < 10; i++) {
            if (!numbers[i].equals("0")) {
                if (i < min) {
                    min = i;
                    numbers[i] = Integer.parseInt(numbers[i]) - 1 + "";
                    stringBuffer.append(min);
                    break;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            int parseInt = Integer.parseInt(numbers[i]);
            if (parseInt > 0) {
                for (int j = 0; j < parseInt; j++) {
                    stringBuffer.append(i);
                }
            }
        }
        System.out.println(stringBuffer.toString());
    }
}
