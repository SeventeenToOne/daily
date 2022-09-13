package leetcode.leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1847 👎 0


import org.apache.commons.collections.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_17 {
    public static Map<Character, String> maps = new HashMap<>();
    static {
        maps.put('2', "abc");
        maps.put('3', "def");
        maps.put('4', "ghi");
        maps.put('5', "jkl");
        maps.put('6', "mno");
        maps.put('7', "pqrs");
        maps.put('8', "tuv");
        maps.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.equals("")) {
            return combinations;
        }
        findCombination(combinations, digits, new StringBuilder(), 0);
        return combinations;
    }

    private static void findCombination(List<String> combinations, String digits, StringBuilder com, int index) {
        if (index == digits.length()) {
            combinations.add(com.toString());
            return;
        }
        char digit = digits.charAt(index);
        String str = maps.get(digit);
        for (int i = 0; i < str.length(); i++) {
            com.append(str.charAt(i));
            findCombination(combinations, digits, com, index + 1);
            com.deleteCharAt(com.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
