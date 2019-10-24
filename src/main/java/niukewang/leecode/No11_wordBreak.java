package niukewang.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithms
 * @description:
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 *
 * Return true because"leetcode"can be segmented as"leet code".
 * @author: wxq
 * @date 2018-10-23 21:05
 **/
public class No11_wordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        if("".equals(s) || s.length() == 0){
            return false;
        }
        if(dict.size() == 0){
            return false;
        }


        boolean[] flag = new boolean[s.length()+1];
        int len = s.length();
        flag[0] = true;

//        for (int i = 1; i <= len; ++i){
//            for (int j = 0; j < i; ++j){
//                if (flag[j] && dict.contains(s.substring(j, i))){
//                    flag[i] = true;
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                if (flag[i] && dict.contains(s.substring(i, j))){
                        flag[j] = true;
                }

            }
        }
        for (int i = 0; i < flag.length; i++) {
            System.out.print(flag[i] + " ");
        }
        System.out.println();
        return flag[len];
    }




    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
//        dict.add("cat");
//        dict.add("cats");
//        dict.add("and");
//        dict.add("sand");
//        dict.add("dog");
//        String s = "catsssanddog";

        String s = "n";
        dict.add("a");

        System.out.println(wordBreak(s, dict));

    }
}
