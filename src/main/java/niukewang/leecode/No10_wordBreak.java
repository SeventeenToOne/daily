package niukewang.leecode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 *
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is["cats and dog", "cat sand dog"].
 *
 * @author: wxq
 * @date 2018-10-22 21:35
 **/
public class No10_wordBreak {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        if(s == "" || s.length() == 0){
            return res;
        }
        boolean[] flag = new boolean[s.length()];
        Arrays.fill(flag, false);
        wordBreakDp(s, dict, "", res, flag);
        return res;
    }

    public static void  wordBreakDp(String s, Set<String> dict, String tmp, ArrayList<String> res, boolean[] flag){

        int len = s.length();
        for (int i = 1; i <= len; i++) {
            String temp = tmp;
            if(dict.contains(s.substring(0, i))){
                if(s.length() == i){
                    temp += s.substring(0, i);
                    res.add(temp);
                }else {
                    if(flag[i] == false){
                        int size = res.size();
                        temp +=  s.substring(0, i) + " ";
                        wordBreakDp(s.substring(i, s.length()), dict, temp, res, flag);
                        if(size == res.size()){
                            flag[i] = true;
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        String s = "catsanddog";
        System.out.println(wordBreak(s, dict));

    }
}
