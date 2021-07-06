import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Rosemary
 * @Description 为了用事实说明挖掘机技术到底哪家强，PAT 组织了一场挖掘机技能大赛。现请你根据比赛结果统计出技术最强的那个学校。
 * <p>
 * 输入格式：
 * 输入在第 1 行给出不超过 10^5的正整数 N，即参赛人数。
 * 随后 N 行，每行给出一位参赛者的信息和成绩，包括其所代表的学校的编号（从 1 开始连续编号）、及其比赛成绩（百分制），中间以空格分隔。
 * <p>
 * 输出格式：
 * 在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。
 * <p>
 * 输入样例：
 * 6
 * 3 65
 * 2 80
 * 1 100
 * 2 70
 * 3 40
 * 3 0
 * 输出样例：
 * 2 150
 * @date 2021/06/30 22:54:39
 */
public class NO2_ExcavatorCompetition {
    //全部运行超时
    public static void main_1(String[] args) {
        Scanner sanner = new Scanner(System.in);
        int n = sanner.nextInt();
        String max = "";
        int maxScroe = -1;
        HashMap<String, Integer> theSchools = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = sanner.nextLine();
            String[] s1 = s.split(" ");
            if (theSchools.containsKey(s1[0])) {
                theSchools.put(s1[0], theSchools.get(s1[0]) + Integer.parseInt(s1[1]));
            } else {
                theSchools.put(s1[0], Integer.parseInt(s1[1]));
            }
        }
        for (Map.Entry<String, Integer> entry : theSchools.entrySet()) {
            Integer score = entry.getValue();
            if (score > maxScroe) {
                maxScroe = score;
                max = entry.getKey() + " " + score;
            }
        }
        System.out.println(max);
    }

    //第三个测试点超时
    public static void main_2(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            int n = Integer.parseInt(s);
            int max = -1;
            int maxScroe = -1;
            HashMap<Integer, Integer> theSchools = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String sco = br.readLine();
                String[] scos = sco.split(" ");
                int school = Integer.parseInt(scos[0]);
                int scoreI = Integer.parseInt(scos[1]);
                if (theSchools.containsKey(school)) {
                    Integer integer = theSchools.get(school);
                    theSchools.put(school, integer + scoreI);
                } else {
                    theSchools.put(school, scoreI);
                }
            }
            for (Map.Entry<Integer, Integer> entry : theSchools.entrySet()) {
                Integer score = entry.getValue();
                if (score > maxScroe) {
                    maxScroe = score;
                    max = entry.getKey();
                }
            }

            System.out.println(max + " " + theSchools.get(max));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int step = 1;
        int maxScroe = -1;
        int[] schools = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            String sco = br.readLine();
            String[] scos = sco.split(" ");
            schools[Integer.parseInt(scos[0])] = schools[Integer.parseInt(scos[0])] + Integer.parseInt(scos[1]);
        }
        for(int i = 1; i <= n; i++){
            if(schools[i]>maxScroe){
                maxScroe= schools[i];
                step=i;
            }
        }
        System.out.println(step+" "+schools[step]);
    }
}
