package leetcode;

/**
 * @program: algorithms
 * @description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author: wxq
 * @date 2019-03-07 21:09
 **/
public class Solution_53_dp {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if((currentSum + nums[i]) > nums[i]){
                currentSum = currentSum + nums[i];
            }else {
                currentSum = nums[i];
            }
            if(maxSum < currentSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1};
        Solution_53_dp s = new Solution_53_dp();
        System.out.println((s.maxSubArray(nums)));

    }
}
