package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-28 21:38
 **/
public class Solution_300_dp {

//    public static int lengthOfLIS(int[] nums) {
//        if (nums.length <3){
//            return 0;
//        }
//        int[] dp = new int[nums.length];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i] = 1;
//        }
//
//        for (int i = 2; i < nums.length; i++) {
//            for (int j = i-1;  j > 0 && nums[i] -nums[j] <= nums[j-1]; j--){
//                for (int k = j -1; k >=0 && nums[i] -nums[j] <= nums[k]; k-- )
//                if (nums[i] - nums[j] == nums[k]) {
//                    dp[i] = Math.max(dp[j] + dp[k] + 1, dp[i]);
//                }
//            }
//        }
//
//        int max = 1;
//        for (int d : dp) {
//            System.out.print(d + " ");
//            if (max < d){
//                max = d;
//            }
//        }
//        System.out.println();
//
//        return max == 1? 0 : max;
//    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        System.out.println(lengthOfLIS(nums));
    }
}
