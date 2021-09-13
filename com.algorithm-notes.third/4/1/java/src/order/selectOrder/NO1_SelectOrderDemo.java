package order.selectOrder;

import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 选择排序demo
 * @date 2021/09/13 21:54:32
 */
public class NO1_SelectOrderDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] charsNew = new int[s1.length];
        for(int i=0;i<charsNew.length-1;i++){
            charsNew[i]=Integer.parseInt(s1[i]);
        }
        for (int i = 0; i <= s1.length - 1; i++) {
            int n = i;
            //选择出这个区间上的最小数字
            for (int j = i; j <= s1.length - 1; j++) {
                Integer a = charsNew[n];
                Integer b = charsNew[j];
                if (b < a) {
                    n = j;
                }
                int temp = charsNew[i];
                charsNew[i] = charsNew[n];
                charsNew[n] = temp;
            }
        }
        for(int i = 0;i<charsNew.length-1;i++){
            System.out.print(charsNew[i]+" ");
        }
    }
}
