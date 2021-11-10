package two_point;

/**
 * @author Rosemary
 * @Description 递归实现排序——方法：归并排序，即递归二分法
 * @date 2021/11/09 21:53:20
 */
public class RecursionOrder {
    public static void main(String[] args) {
        int[] b = {987, 54, 8, 6, 87, 3214, 798, 354, 3218, 948, 9624, 32187, 654, 200, 116, 996, 774, 554, 21};
        int[] order = getOrder(b, 0, b.length - 1);
        for (int a : order) {
            System.out.print(a + " ");
        }
    }


    public static int[] getOrder(int[] a, int left, int right) {
        //没有排到边缘
        if (left < right) {
            int mid = (left + right) / 2;
            //先左后右
            System.out.println("开始向左递归寻找左标为" + left + "右标为" + mid);
            getOrder(a, left, mid);
            System.out.println("开始向右递归寻找左标为" +(mid + 1 )+ "右标为" + right);
            getOrder(a, mid + 1, right);
            System.out.println("开始合并左标1为" + left + "右标1为" + mid + "左标2为" + (mid + 1) + "右标2为" + right);
            orderSort(a, left, right, mid, mid + 1);
        }
        return a;
    }


    public static int[] orderSort(int[] a, int left, int right, int mid, int midBeLong) {
        int i = left;
        int j = midBeLong;
        int[] temp = new int[19];
        int index = 0;
        //比较大小
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[index++] = a[i++];
            } else {
                temp[index++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= right) {
            temp[index++] = a[j++];
        }
        //因为是二分法且是递归所以要重新赋值
        for (int k = 0; k < index; k++) {
            a[left + k] = temp[k];
        }
        return a;
    }
}
