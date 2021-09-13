package order.insertOrder;

import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 插入排序demo
 * @date 2021/09/13 21:54:32
 */
public class NO1_InsertOrderDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] charsNew = new int[s1.length + 1];
        for (int i = 0; i < charsNew.length; i++) {
            charsNew[i] = Integer.parseInt(s1[i]);
        }
        //从第二个开始对比
        for (int i = 1; i < charsNew.length - 1; i++) {
            int temp = charsNew[i];
            int j = i;
            //替换位置
            while (j > 0 && temp < charsNew[j - 1]) {
                charsNew[j] = charsNew[j - 1];
                j--;
            }
            charsNew[j] = temp;
        }
        for (int i = 0; i < charsNew.length - 1; i++) {
            System.out.print(charsNew[i] + " ");
        }
    }
}
