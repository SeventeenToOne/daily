package leetcode.leetcode.editor.cn;//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 1263 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_50 {
    public List<Integer> spiralOrder(int[][] matrix) {
        String str = "dogs";
        int[] nums = new int[123];
        Arrays.stream(nums).sum();
        str.hashCode();
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];

        int[][] test2 = new int[10][2];
        Arrays.sort(test2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        Arrays.sort(test2, (a, b) -> Integer.compare(a[0], b[0]));

        int num = matrix.length * matrix[0].length;
        List<Integer> paths = new ArrayList<>();
        System.out.println(str.substring(3, 4));
        int i = 0, j = 0;
        while (num > 0) {
            // 从左往右
            while (j < matrix[0].length && flag[i][j] != true) {
                paths.add(matrix[i][j]);
                flag[i][j] = true;
                j++;
                num--;
            }
            // 转下
            j--;
            i++;
            // 从上往下
            while (i < matrix.length && flag[i][j] != true) {
                flag[i][j] = true;
                paths.add(matrix[i][j]);
                i++;
                num--;
            }
            i--;
            j--;
            // 从右往左
            while (j >= 0 && flag[i][j] != true) {
                flag[i][j] = true;
                paths.add(matrix[i][j]);
                j--;
                num--;
            }
            j++;
            i--;
            // 从下往上
            while (i >= 0 && flag[i][j] != true) {
                flag[i][j] = true;
                paths.add(matrix[i][j]);
                i--;
                num--;
            }
            i++;
            j++;
        }
        return paths;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution_50 solution = new Solution_50();
        System.out.println(solution.spiralOrder(matrix));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
