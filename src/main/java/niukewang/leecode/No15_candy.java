package niukewang.leecode;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 *
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * @author: wxq
 * @date 2018-10-25 21:13
 **/
public class No15_candy {
    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i-1] < ratings[i]){
                nums[i] = nums[i-1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0 ; i--){
            if ((ratings[i-1] > ratings[i]) && nums[i-1] <= nums[i]) {
                nums[i-1] = nums[i] + 1;
            }
        }
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1, 3, 4, 4, 2, 4, 5};
        System.out.println(candy(ratings));
        int[] ratings1 = new int[]{2, 1};
        System.out.println(candy(ratings1));
        int[] ratings2 = new int[]{1, 0, 2};
        System.out.println(candy(ratings2));
        int[] ratings3 = new int[]{2};
        System.out.println(candy(ratings3));

    }
}
