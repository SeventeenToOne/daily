package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-23 20:36
 **/
public class Solution_392_dp {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0){
            return true;
        }

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int j = 0;
        for (int i = 0; i < tchar.length; i++) {
            if(j < schar.length && schar[j] == tchar[i]){
                j++;
            }
            if (j == schar.length) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s  = "axc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
