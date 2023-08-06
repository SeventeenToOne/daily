package leetcode.leetcode.editor.cn;//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1926 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import apple.laf.JRSUIUtils;
import demo.DataDeal;

import java.lang.ref.WeakReference;

//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
class Solution {
    public int[] searchRange(int[] nums, int target) {

        WeakReference<DataDeal> weakReference = new WeakReference(new DataDeal());
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return findRange(nums, target, mid);
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] findRange(int[] nums, int target, int index) {
        int left = index, right = index;
        while (left > 0 && nums[left-1] == target) {
            left--;
        }

        while (right < nums.length - 1 && nums[right + 1] == target) {
           right++;
        }
        return new int[]{left, right};
    }

}
//leetcode submit region end(Prohibit modification and deletion)
