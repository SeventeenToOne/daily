package leetcode;

/**
 * @program: algorithms
 * @description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @author: wxq
 * @date 2019-03-07 20:52
 **/
public class Solution_70_dp {
    public int climbStairs(int n) {
        int num = 1, preNum = 1;
        for (int i = 2; i <= n; i++) {
            if(i == 2){
                num = 2;
                continue;
            }
            int t = num;
            num += preNum;
            preNum = t;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution_70_dp solution = new Solution_70_dp();
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
    }
}
