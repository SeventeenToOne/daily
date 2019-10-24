package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-06-03 20:53
 **/
public class Solution_416_dp {
    int[] dp;
    int[] temp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0 || nums.length < 2){
            return false;
        }
        int subSum = sum/2;
        dp = new int[subSum+1];
        temp = new int[subSum+1];

        dp[nums[0]] = subSum - nums[0];
        dp[0] = subSum;
        dp[subSum] = -1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < dp.length; j++) {

                if (dp[j] > 0 && j + nums[i] <= subSum){
                    temp[j + nums[i]] = dp[j] - nums[i];
                    if (j + nums[i] == subSum &&  dp[j] - nums[i] == 0){
                        return true;
                    }
                }

                if (dp[j] > 0){
                    temp[j] = dp[j];
                }

            }
            dp = temp;
            temp = new int[subSum+1];

        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(new Solution_416_dp().canPartition(nums));

        int[] nums1 = new int[]{1, 2, 5};
        System.out.println(new Solution_416_dp().canPartition(nums1));
    }
}
