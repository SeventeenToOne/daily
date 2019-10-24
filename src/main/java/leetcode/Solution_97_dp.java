package leetcode;

public class Solution_97_dp {

    // dp解法
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null){
            return s3.equals(s2);
        }
        if (s2 == null){
            return s3.equals(s1);
        }

        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        int s1Len = s1.length() + 1;
        int s2Len = s2.length() + 1;

        boolean[][] dp = new boolean[s1Len][s2Len];
        for (int i = 0; i < s1Len; i++) {
            for (int j = 0; j < s2Len; j++) {
                dp[i][j]  = false;
            }
        }

        for (int i = 0; i < s1Len; i++) {
            for (int j = 0; j < s2Len; j++) {
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1);
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1);
                }else {
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1))
                            || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    // 回溯的方法求解
    public boolean isInterleaveRecur(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        int[][] memory = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memory[i][j] = -1;
            }
        }

        return isInterleaveRecur(s1, 0, s2, 0, s3, 0, memory);
    }

    private boolean isInterleaveRecur(String s1, int index1, String s2, int index2, String s3, int index3, int[][] m){
        if(index1 == s1.length()){
            return s2.substring(index2).equals(s3.substring(index3));
        }

        if (index2 == s2.length()){
            return s1.substring(index1).equals(s3.substring(index3));
        }

        if(m[index1][index2] >=0){
            return m[index1][index2] == 1;
        }

        boolean ans = false;
        if( (s1.charAt(index1) == s3.charAt(index3) && isInterleaveRecur(s1, index1 + 1, s2, index2, s3, index3 + 1, m))
                || (s2.charAt(index2) == s3.charAt(index3) && isInterleaveRecur(s1, index1, s2, index2 + 1, s3, index3 +1, m) )){

            ans = true;
        }

        if (ans){
            m[index1][index2] = 1;
        }else {
            m[index1][index2] = 0;
        }

        return ans;

    }


    public static void main(String[] args) {
        Solution_97_dp s = new Solution_97_dp();
        System.out.println(s.isInterleaveRecur("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(s.isInterleaveRecur("a", "d", "a"));

    }
}

/*
97. 交错字符串

示例 1:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
示例 2:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出: false

* */