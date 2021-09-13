package chapter_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Rosemary
 * @Description
 * 输入两个非负 10 进制整数 A 和 B (≤2^(30−1))，输出 A+B 的 D (1<D≤10)进制数。
 *
 * 输入格式：
 * 输入在一行中依次给出 3 个整数 A、B 和 D。
 *
 * 输出格式：
 * 输出 A+B 的 D 进制数。
 *
 * 输入样例：
 * 123 456 8
 * 输出样例：
 * 1103
 * @date 2021/09/9 9:38:39
 */
public class NO4_Ds_APlusB {
    //部分正确 146 ms 15304 KB
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        long a = Long.parseLong(s1[0]);
        long b = Long.parseLong(s1[1]);
        long d = Long.parseLong(s1[2]);
        long sum = a + b;
        long temp=sum;
        if(sum==0){
            System.out.println("0");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (temp>0){
            long l = temp % d;
            stringBuffer.append(l);
            temp=temp / d;
            if(temp==1){
                stringBuffer.append(temp % d);
            }
        }
        char[] chars = stringBuffer.toString().toCharArray();
        StringBuffer stringBuffer1 = new StringBuffer();
        for(int i=chars.length-1;i>=0;i--){
            stringBuffer1.append(chars[i]);
        }
        System.out.println(stringBuffer1.toString());
    }
    public static void main_2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] eles = line.split(" ");
        long a = Long.parseLong(eles[0]);
        long b = Long.parseLong(eles[1]);
        int c = Integer.parseInt(eles[2]);
        long sum = a + b;
        if (sum == 0) {
            System.out.println("0");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (sum > 0) {
            //把除以基数的余数存到缓冲区中
            stringBuffer.append(sum % c);
            sum /= c;
        }

        System.out.println(stringBuffer.reverse().toString());
    }
}
