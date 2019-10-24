package niukewang.leecode;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 * @author: wxq
 * @date 2018-10-29 21:27
 **/
public class No17_minCut {
    private int[][] cutNums = new int[1000][1000];
    private String s;
    public  int minCut(String s) {
        this.s = s;
        for (int t = 0; t < s.length(); t++) {
            for (int i = 0, j = t; j < s.length(); i++, j++){
                cutNums[i][j] = min(i , j);
            }
        }
        return cutNums[0][s.length()-1];
    }

    public  int min(int i , int j){
        if(isPalindrome(i, j)){
            return 0;
        }
        int min = s.length();
        for (int p = i; p < j; p++){
            int a = cutNums[i][p];
            int b = cutNums[p+1][j];
            a = a + b + 1;
            min = min > a ? a : min;
        }
        return min;
    }

    public  boolean isPalindrome(int i, int j){
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aababa";
        No17_minCut minCut = new No17_minCut();
        System.out.println(minCut.minCut(s));
    }
}
