import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 字符串 APPAPT 中包含了两个单词 PAT，其中第一个 PAT 是第 2 位(P)，
 * 第 4 位(A)，第 6 位(T)；第二个 PAT 是第 3 位(P)，第 4 位(A)，第 6 位(T)。
 * <p>
 * 现给定字符串，问一共可以形成多少个 PAT？
 * <p>
 * 输入格式：
 * 输入只有一行，包含一个字符串，长度不超过10
 * 5
 * ，只包含 P、A、T 三种字母。
 * <p>
 * 输出格式：
 * 在一行中输出给定字符串中包含多少个 PAT。由于结果可能比较大，只输出对 1000000007 取余数的结果。
 * <p>
 * 输入样例：
 * APPAPT
 * 结尾无空行
 * 输出样例：
 * 2
 * @date 2021/11/15 23:28:40
 */
public class HowManyPAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] ts = line.split("T");
        int total=0;
        for (int i = 0; i < ts.length; i++) {
            String t = ts[i];
            char[] chars = t.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (char x : chars) {
                if (stringBuffer.length() == 3) {
                    stringBuffer.delete(0, 2);
                }
                if (stringBuffer.length() < 3) {
                    if(stringBuffer.length() == 0){
                        if (x == 'P') {
                            stringBuffer.append(x);
                        }
                    }

                    if (x == 'A') {
                        stringBuffer.append(x);
                    }
                }
            }
        }
    }
}
