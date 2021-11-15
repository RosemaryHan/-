package fastOrder;

import java.lang.ref.WeakReference;

/**
 * @author Rosemary
 * @Description 快速排序--On(nlogn)--最惨On(n^2)
 * @date 2021/11/11 20:41:09
 */
public class FastOrder {
    public static void main(String[] args) {
        int[] a = {987, 54, 8, 6, 87, 3214, 798, 354};
        quickSort(a, 0, a.length - 1);
        for (int b : a) {
            System.out.print(b + " ");
        }
    }

    public static int partition(int[] a, int left, int right) {
        int temp = a[left];
        //保证坐标不超位
        while (left < right) {
            //查证这个对象在目标数的右边
            while (left < right && a[right] >= temp) {
                System.out.println("向左移的right=" + right+"\n");
                right--;
            }
            a[left] = a[right];
            for (int b : a) {
                System.out.print(b + " ");
            }
            while (left < right && a[left] <= temp) {
                System.out.println("向右移的left=" + left+"\n");
                left++;
            }
            a[right] = a[left];
            for (int b : a) {
                System.out.print(b + " ");
            }
        }
        a[left] = temp;
        System.out.println("\n"+"中间席位为" + left+"\n");
        for (int b : a) {
            System.out.print(b + " ");
        }
        return left;
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            System.out.println("二分法开始");
            int partition = partition(a, left, right);
            System.out.println("左边排序，此时的Left是" + left + "right是：" + partition);
            quickSort(a, left, partition);
            System.out.println("右边排序，此时的Left是" + (partition + 1) + "right是：" + right);
            quickSort(a, partition + 1, right);
        }
    }
}
