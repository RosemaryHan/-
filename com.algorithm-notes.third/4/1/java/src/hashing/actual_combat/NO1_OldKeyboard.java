package hashing.actual_combat;

import java.util.*;

/**
 * @author Rosemary
 * @Description 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
 * <p>
 * 输入格式：
 * 输入在 2 行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过 80 个字符的串，由字母 A-Z（包括大、小写）、数字 0-9、以及下划线 _（代表空格）组成。题目保证 2 个字符串均非空。
 * <p>
 * 输出格式：
 * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有 1 个坏键。
 * <p>
 * 输入样例：
 * 7_This_is_a_test
 * _hs_s_a_es
 * 结尾无空行
 * 输出样例：
 * 7TI
 * @date 2021/09/17 22:58:24
 */
public class NO1_OldKeyboard {

    public static void main_1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shouldScan = scanner.nextLine();
        shouldScan = shouldScan.toUpperCase();
        char[] chars = shouldScan.toCharArray();
        int length = chars.length;
        String realScan = scanner.nextLine();
        realScan = realScan.toUpperCase();
        char[] charArray = realScan.toCharArray();
        HashMap<String, Boolean> characterBooleanHashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            characterBooleanHashMap.put(String.valueOf(chars[i]), false);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (characterBooleanHashMap.containsKey(String.valueOf(charArray[i]))) {
                characterBooleanHashMap.put(String.valueOf(chars[i]), true);
            }
        }
        Set<Map.Entry<String, Boolean>> entries = characterBooleanHashMap.entrySet();
        entries.stream().forEach(x -> {
            if (x.getValue() == false) {
                System.out.print(x.getKey());
            }
        });
    }

    //运行超时
    public static void main_2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shouldScan = scanner.nextLine();
        shouldScan = shouldScan.toUpperCase().replace(" ", "_");
        char[] chars = shouldScan.toCharArray();
        int length = chars.length;
        String realScan = scanner.nextLine();
        realScan = realScan.toUpperCase().replace(" ", "_");
        char[] charArray = realScan.toCharArray();
        Set<Character> sout = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            boolean flag = true;
            for (int j = 0; j < charArray.length; j++) {
                char c1 = charArray[j];
                if (c == c1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sout.add(c);
            }
        }
        sout.forEach(x -> System.out.print(x));
    }


    //结果： 全部正确 耗时：145 ms      内存：15464 KB
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shouldScan = scanner.nextLine();
        //直接转换
        boolean sout[] = new boolean[128];
        for (int i = 0; i < sout.length; i++) {
            sout[i] = false;
        }
        char[] chars = shouldScan.toCharArray();
        int length = chars.length;
        String realScan = scanner.nextLine();
        char[] charArray = realScan.toCharArray();
        for (int i = 0; i < length; i++) {
            int j;
            char aChar = chars[i];
            for ( j = 0; j < charArray.length; j++) {
                char c = charArray[j];
                if(aChar>='a'&&aChar<='z'){
                    aChar-=32;
                }
                if(c>='a'&&c<='z'){
                    c-=32;
                }
                if(c==aChar){
                    break;
                }
            }
            if(j==charArray.length&&sout[aChar]==false){
                System.out.print(aChar);
                sout[aChar]=true;
            }

        }

    }
}
