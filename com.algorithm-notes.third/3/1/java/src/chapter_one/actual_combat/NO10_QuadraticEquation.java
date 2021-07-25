package actual_combat;

import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 设计函数求一元多项式的导数。（注：x^n
 * （n为整数）的一阶导数为nx^n−1。）
 * <p>
 * 输入格式:
 * 以指数递降方式输入多项式非零项系数和指数（绝对值均为不超过 1000 的整数）。数字间以空格分隔。
 * <p>
 * 输出格式:
 * 以与输入相同的格式输出导数多项式非零项的系数和指数。数字间以空格分隔，但结尾不能有多余空格。
 * 注意“零多项式”的指数和系数都是 0，但是表示为 0 0。
 * <p>
 * 输入样例:
 * 3 4 -5 2 6 1 -2 0
 * 输出样例:
 * 12 3 -10 1 6 0
 * @date 2021/07/22 21:32:34
 */
public class NO10_QuadraticEquation {
    //结果如下： 部分正确（前两个点错误） 内存： 15572   KB    耗时： 141    ms
    public static void main_1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] values = nextLine.split(" ");
        if (values.length == 2 && values[1].equals("0")) {
            System.out.print("0 0");
        } else {
            String outstring = "";
            for (int i = 0; i < values.length; i = i + 2) {
                int a = Integer.parseInt(values[i]) * Integer.parseInt(values[i + 1]);
                int b = Integer.parseInt(values[i + 1]) - 1;
                if (a == 0) continue;
                outstring = outstring + a + " " + b + " ";
            }
            System.out.print(outstring.substring(0, outstring.length() - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split("\\s+");
        StringBuffer result = new StringBuffer();
        for(int i = 0;i<split.length;i+=2){

            //系数非0指数为0
            if(Integer.parseInt(split[i+1]) == 0 && Integer.parseInt(split[i]) != 0 ){
                continue;
            }

            //系数为0
            if(Integer.parseInt(split[i]) == 0){
                result.append(0+" ");
                result.append(0+" ");
                continue;
            }

            //普通情况
            result.append(Integer.parseInt(split[i])*Integer.parseInt(split[i+1])+" "+(Integer.parseInt(split[i+1])-1)+" ");
        }
        if(result.length() == 0){//空串时输出0 0
            System.out.println("0 0");
        }else{
            System.out.println(result.substring(0, result.length()-1));
        }
    }
}
