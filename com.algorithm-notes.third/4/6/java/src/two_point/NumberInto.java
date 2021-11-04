package two_point;

/**
 * @author Rosemary
 * @Description 序列并归——两个递增序列合并
 * @date 2021/11/04 23:59:17
 */
public class NumberInto {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int index = 0;

        int[] a = {1, 5, 9, 30, 56, 60, 90, 123, 456, 789, 123456, 987654};
        int[] b = {2, 6, 8, 98, 100, 111, 333, 444, 555, 666, 777, 888, 999, 12568, 89548, 110000};
        int aIndex = a.length;
        int bIndex = b.length;
        int[] total = new int[aIndex+bIndex];
        //先循环完一组
        while (i < aIndex && j < bIndex) {
        //如果a小于b那么a先加入total集合中
            if (a[i] < b[j]) {
                total[index] = a[i];
                index++;
                i++;
            } else {
                total[index] = b[j];
                index++;
                j++;
            }
        }
        //补充后一组
        while (i<aIndex){
            total[index++]=a[i++];
        }
        while (j<bIndex){
            total[index++]=b[j++];
        }
        System.out.println(aIndex);
        System.out.println(bIndex);
        System.out.println(bIndex+aIndex);
        for(int k=0;k<total.length;k++){
            System.out.print(total[k]+" ");
        }
    }
}
