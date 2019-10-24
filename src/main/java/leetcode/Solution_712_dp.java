package leetcode;

/**
 * @program: algorithms
 * @description:
 * 示例 1:
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 *
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 注意:
 *
 * 0 < s1.length, s2.length <= 1000。
 * 所有字符串中的字符ASCII值在[97, 122]之间。
 * @author: wxq
 * @date 2019-03-15 13:25
 **/
public class Solution_712_dp {
    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dist = new int[s1.length()+1][s2.length()+1];

        dist[0][0] = 0;
        for (int i = 1; i < s1.length()+1; i++) {
            dist[i][0] = s1.charAt(i-1) + dist[i-1][0];
        }
        for (int i = 1; i < s2.length()+1; i++) {
            dist[0][i] = s2.charAt(i-1) + dist[0][i-1];
        }

        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist[i].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dist[i][j] = dist[i-1][j-1];
                }else {
                    dist[i][j] = Math.min(dist[i][j-1] + s2.charAt(j-1), dist[i-1][j] + s1.charAt(i-1));
                    dist[i][j] = Math.min(dist[i-1][j-1] + s1.charAt(i-1) + s2.charAt(j-1), dist[i][j]);
                }
            }
        }

        return dist[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println(minimumDeleteSum(s1, s2));
    }
}
