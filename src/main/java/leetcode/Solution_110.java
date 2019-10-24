package leetcode;

public class Solution_110 {
    boolean res  = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        DFS(root);
        return res;

    }

    public int DFS(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHight = DFS(node.left) + 1;
        int rightHight = DFS(node.right) + 1;

        if(Math.abs(rightHight - leftHight) > 1){
            res = false;
        }

        return Math.max(leftHight, rightHight);
    }

    public static void main(String[] args) {

    }
}

//110. 平衡二叉树




/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
* */
