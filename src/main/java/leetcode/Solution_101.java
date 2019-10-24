package leetcode;

public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);

    }

    public boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null){
            return false;
        }
        if (right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        boolean l = true, r = true;

        l = dfs(left.left, right.right);
        r = dfs(left.right, right.left);

        return r && l;
    }

}
