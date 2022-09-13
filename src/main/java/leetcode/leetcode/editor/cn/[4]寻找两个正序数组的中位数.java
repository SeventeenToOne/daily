package leetcode.leetcode.editor.cn;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 5227 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_tengxun_04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sum = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            int n1 = nums1[i];
            int n2 = nums2[j];
            if (n1 < n2) {
                sum[k++] = n1;
                i++;
            } else {
                sum[k++] = n2;
                j++;
            }
        }
        while (i < nums1.length) {
            sum[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            sum[k++] = nums2[j++];
        }
        double midValue = 0;
        //for (int i1 : sum) {
        //    System.out.println(i1);
        //}
        if (sum.length % 2 == 1) {
            midValue = sum[sum.length / 2];
        } else {
            midValue = (sum[sum.length / 2 - 1] + sum[sum.length / 2]) / 2.0;
        }
        return midValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
