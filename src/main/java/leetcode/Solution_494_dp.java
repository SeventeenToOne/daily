package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-31 20:58
 **/
public class Solution_494_dp {
    int[] preDp;
    int[] dp;

    public int findTargetSumWays(int[] nums, int S) {


        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || -sum > S){
            return  0;
        }

        preDp = new int[2 * sum + 1];
        dp = new int[2 * sum + 1];

        preDp[sum + nums[0]] = 1;
        preDp[sum - nums[0]] = preDp[sum - nums[0]] + 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                if(preDp[j] > 0 && j - nums[i] >= 0 && j + nums[i] <  2 * sum + 1){
                    dp[j - nums[i]] = dp[j - nums[i]] + preDp[j];
                    dp[j + nums[i]] = dp[j + nums[i]] + preDp[j];
                }
            }
            preDp = dp;
            dp = new int[2 * sum + 1];
        }

        return S > 0 ? preDp[sum + S]: preDp[sum - S];
    }

    public static void main(String[] args) {


        int[] nums = new int[]{1, 1, 1, 1, 1};
        int s = 3;
        System.out.println(new Solution_494_dp().findTargetSumWays(nums, s));

        int[] nums1 = new int[]{0,0,0,0,0,0,0,0,1};
        int s1 = 1;
        System.out.println(new Solution_494_dp().findTargetSumWays(nums1, s1));
    }
}
