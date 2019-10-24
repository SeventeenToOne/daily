package leetcode;

/**
 * @program: algorithms
 * @description:
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 *
 * @author: wxq
 * @date 2019-05-10 13:46
 **/
public class Solution_647_dp {
    public static int countSubstrings(String s) {
        int count = 0;
        char[] schar = s.toCharArray();
        for (int i = 0; i < schar.length; i++) {
            // 子串是基数
            int left = i, right = i;
            while( left >= 0 && right <schar.length && schar[left] == schar[right]){
                left--;
                right++;
                count++;
            }

            left = i;
            right = i + 1;
            while( left >= 0 && right <schar.length && schar[left] == schar[right]){
                left--;
                right++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("sas"));
    }
}
