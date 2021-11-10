package two_point;

/**
 * @author Rosemary
 * @Description 非递归实现排序——方法：归并排序，即递归二分法
 * @date 2021/11/09 21:53:20
 */
public class UnrecursionOrder {
    public static void main(String[] args) {
        int[] a = {987, 54, 8, 6, 87, 3214, 798, 354};

        getOrder(a);
        for (int b : a) {
            System.out.print(b + " ");
        }
    }

    public static void getOrder(int[] a) {
        //二分法两组为一个
        //第一个循环分组
        for (int temp = 1; temp / 2 < a.length; temp *= 2) {
            //第二个循环解决分组后的合并
            for (int i = 0; i < a.length; i += temp) {
                int mid = (i + temp )/ 2 ;
                if (mid + 1 < a.length) {
                    sort(a, i, mid, mid + 1, Math.min(i + temp, a.length));
                }
            }
        }
    }
//突然被双重循环卡住可还行？？？？
    public static void sort(int[] a, int left1, int right1, int left2, int right2) {
        int i = left1;
        int j = left2;
        int index = 0;
        int[] temp = new int[100];
        while (i <= right1 && j <= right2) {
            if (a[i] <= a[j]) {
                temp[index++] = a[i++];
            } else {
                temp[index++] = a[j++];
            }
        }
        while (i <= right1) {
            temp[index++] = a[i++];
        }
        while (j <= right2) {
            temp[index++] = a[j++];
        }
        for (int k = 0; k < index; k++) {
            a[left1+k] = temp[k];
        }
    }
}
