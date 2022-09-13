package leetcode.leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2861 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_22_tengxun {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    public void generate(StringBuilder cur, int left, int right, int n, List<String> result) {
        if (cur.length() == n * 2) {
            System.out.println(cur.toString() + " len:" + cur.length());
            result.add(cur.toString());
            return;
        }

        if (left < n) {
            cur.append('(');
            generate(cur, left + 1, right, n, result);
            cur.deleteCharAt(cur.length() - 1);
            System.out.println("left: " + cur);
        }

        if (right < left) {
                cur.append(')');
            generate(cur, left, right + 1, n, result);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_22_tengxun().generateParenthesis(3));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
