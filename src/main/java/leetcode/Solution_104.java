package leetcode;

import java.util.*;

public class Solution_104 {
    int maxDeep = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        dfs(root, 0);
        return maxDeep;
    }

    public void dfs(TreeNode node, int deep){
        if(node == null){
            return ;
        }

        deep++;

        if(node.left == null && node.right == null){
            maxDeep = Math.max(deep, maxDeep);
        }
        if(node.left != null){
            dfs(node.left, deep);
        }
        if(node.right != null){
            dfs(node.right, deep);
        }

        deep--;
    }
}
