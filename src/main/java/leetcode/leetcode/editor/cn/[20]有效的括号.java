package leetcode.leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 3412 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_20 {

    static Map<Character, Character> characters = new HashMap<>();
    static {
        characters.put(')', '(');
        characters.put('}', '{');
        characters.put(']', '[');
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!characters.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() != characters.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
