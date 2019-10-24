package bishi.bilibili2019;

import java.util.*;
public class Main {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String words[] = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {

            // 修改 开始
            if (words[i].length() == 0) {
                stringBuilder.append(" ");
                continue;
            }
            //修改 结束

            if (words[i].length() % 2 == 0) {
                stringBuilder.append(words[i]);
            } else {
                char[] chars = words[i].toCharArray();

                char tempt = ' ';
                int len = chars.length;
                for (int j = 0; j <= len / 2 - 1; j++) {
                    tempt = chars[j];
                    chars[j] = chars[len - 1 - j];
                    chars[len - 1 - j] = tempt;
                }
                for (int j = 0; j < len; j++) {
                    stringBuilder.append(chars[j] + "");
                }
            }
            stringBuilder.append(" ");
        }
        String string = stringBuilder.toString();
        System.out.println(string.substring(0, string.length() - 1));
    }
}
//    123 32  123  1232 3132   3231