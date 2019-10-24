package niukewang.leecode;

/**
 * @program: algorithms
 * @description: 牛客网Leecode 1 ：树的广度优先遍历，第一个叶子节点就是最小深度
 * @author: wxq
 * @date 2018-10-10 21:18
 **/

import sun.reflect.generics.tree.Tree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * public class Solution {
 *    public int run(TreeNode root) {
 *
 *    }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
public class minimum_depth_of_binary_tree {
//    递归版本
//    public int run(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int leftDepth = run(root.left);
//        int rightDepth = run(root.right);
//        if(leftDepth == 0 || rightDepth == 0){
//            return leftDepth + rightDepth + 1;
//        }
//        return Math.min(leftDepth, rightDepth) + 1;
//    }


//    public static int miniDepth(TreeNode node, int depth){
//        if (node == null){
//            return depth;
//        }
//        depth++;
//        int leftDepth = miniDepth(node.left, depth);
//        int rightDepth = miniDepth(node.right, depth);
//        return leftDepth > rightDepth ? rightDepth:leftDepth;
//    }
}
