package intervalgreed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rosemary
 * @Description 暑假到了，小明终于可以开心的看电视了。但是小明喜欢的节目太多了，他希望尽量多的看到完整的节目。
 * 现在他把他喜欢的电视节目的转播时间表给你，你能帮他合理安排吗？
 * 输入
 * 输入包含多组测试数据。每组输入的第一行是一个整数n（n<=100），表示小明喜欢的节目的总数。
 * 接下来n行，每行输入两个整数si和ei（1<=i<=n），表示第i个节目的开始和结束时间，为了简化问题，每个时间都用一个正整数表示。
 * 当n=0时，输入结束。
 * 输出
 * 对于每组输入，输出能完整看到的电视节目的个数。
 * 样例输入 Copy
 * 12
 * 1 3
 * 3 4
 * 0 7
 * 3 8
 * 15 19
 * 15 20
 * 10 15
 * 8 18
 * 6 12
 * 5 10
 * 4 14
 * 2 9
 * 0
 * 样例输出 Copy
 * 5
 * @date 2021/09/25 22:40:20
 */
public class NO1_TVWatching {

    static class Shows {
        Integer begin;
        Integer end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s;
        boolean flag = true;
        while (flag) {
            s = bufferedReader.readLine();
            n = Integer.parseInt(s);
            if (n == 0) {
                flag = false;
            } else {
                Shows[] showList = new Shows[n];
                for (int i = 0; i < n; i++) {
                    String shows = bufferedReader.readLine();
                    String[] time = shows.split(" ");
                    Shows show = new Shows();
                    show.begin = Integer.parseInt(time[0]);
                    show.end = Integer.parseInt(time[1]);
                    showList[i] = show;
                }
                //对获得的时间表排序
                for (int i = 0; i < showList.length - 1; i++) {
                    for (int j = 0; j < showList.length - 1 - i; j++) {
                        if (showList[j].end <= showList[j + 1].end) {
                            if(showList[j].end.equals(showList[j + 1].end)){
                                if(showList[j+1].begin < showList[j].begin){
                                    Shows show = showList[j+1];
                                    showList[j+1] = showList[j];
                                    showList[j] = show;
                                }else{
                                    Shows show = showList[j];
                                    showList[j] = showList[j+1];
                                    showList[j+1] = show;
                                }
                            }else{
                                Shows show = showList[j+1];
                                showList[j+1] = showList[j];
                                showList[j] = show;
                            }

                        }
                    }
                }
                //开始筛选不相邻的时间区间
                //等于一是为了加上这个比较时间段的本身
                int ans = 1;
                int lastBeginTime = showList[0].begin;
                for (int i = 0; i < showList.length - 1; i++) {
                    if (i <= showList.length - 2) {
                        if (showList[i + 1].end <= lastBeginTime) {
                            lastBeginTime = showList[i + 1].begin;
                            ans++;
                        }
                    }
                }
                System.out.println(ans);
            }
        }
    }
}