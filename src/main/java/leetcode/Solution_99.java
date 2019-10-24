package leetcode;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;

public class Solution_99 {
    TreeNode fistReverNode;
    TreeNode secondReverNode;
    TreeNode preNode;

    public void recoverTree(TreeNode root) {
        InOder(root);
        if (fistReverNode != null && secondReverNode != null){
            int temp = fistReverNode.val;
            fistReverNode.val = secondReverNode.val;
            secondReverNode.val = temp;
        }
    }

    public void InOder(TreeNode node){
        if(node == null){
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if(preNode != null && node.val < preNode.val){
                if(fistReverNode == null){
                    fistReverNode = preNode;
                    secondReverNode = node;
                }else {
                    secondReverNode = node;
                }
            }
            preNode = node;
            node = node.right;

        }
    }
}
/*
99. 恢复二叉搜索树

二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。
* */