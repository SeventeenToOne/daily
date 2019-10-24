package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_124_Tree {
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calMaxRoad(root);
        return maxValue ;
    }

    public int calMaxRoad(TreeNode root){
        if (root == null){
            return 0;
        }
        int left_gain = Math.max(calMaxRoad(root.left), 0);
        int right_gain = Math.max(calMaxRoad(root.right), 0);

        int curMaxValue = left_gain + right_gain + root.val;
        maxValue = Math.max(maxValue, curMaxValue);

        return root.val + Math.max(left_gain, right_gain);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
