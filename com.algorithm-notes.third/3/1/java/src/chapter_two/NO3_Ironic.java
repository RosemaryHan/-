package chapter_two;

import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 题目描述
 * 读入一串字符，判断是否是回文串。“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 * <p>
 * 输入
 * 一行字符串，长度不超过255。
 * <p>
 * 输出
 * 如果是回文串，输出“YES”，否则输出“NO”。
 * <p>
 * 样例输入 Copy
 * 12321
 * 样例输出 Copy
 * YES
 * @date 2021/07/14 22:38:27
 */
public class NO3_Ironic {

    //结果如下 ： 正确 内存：14860KB 时间：307ms
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String trim = nextLine.trim();
        String[] s = trim.split(" ");
        for(int i=s.length-1;i>=0;i--){
            System.out.print(s[i]);
            if(i!=0){
                System.out.println(" ");
            }
        }
    }

}
