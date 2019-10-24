package leetcode;

/**
 * @program: algorithms
 * @description:
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * @author: wxq
 * @date 2019-04-02 13:29
 **/
public class Solution_413_dp {
    public static int  numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int add = 0;

        if(A == null || A.length < 2){
            return 0;
        }
        for (int i = 2; i < A.length; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                count += ++add;
            }else {
                add = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 7, 5, 6};
        System.out.println(numberOfArithmeticSlices(A));
    }
}
