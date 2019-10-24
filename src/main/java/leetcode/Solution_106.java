package leetcode;

import sun.reflect.generics.tree.Tree;

public class Solution_106 {
    int curIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return  null;
        }
        curIndex = postorder.length-1;
        TreeNode root = build(inorder, postorder, 0, inorder.length-1);

        return root;
    }

    public TreeNode build(int[] inorder, int[] postorder, int low, int hight){
        if(hight < low){
            return null;
        }


        if(curIndex < 0){
            return null;
        }

        TreeNode node = new TreeNode(postorder[curIndex]);

        int inorderIndex = 0;
        for(int i = low; i<=hight; i++){
            if(inorder[i] == postorder[curIndex]){
                inorderIndex = i;
                break;
            }
        }
        curIndex--;
        node.right = build(inorder, postorder, inorderIndex+1, hight);
        node.left = build(inorder, postorder, low, inorderIndex-1);

        return node;

    }

}
//106. 从中序与后序遍历序列构造二叉树