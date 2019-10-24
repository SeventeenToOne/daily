package niukewang.leecode;

import edu.princeton.cs.algs4.In;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree{1,#,2,3},
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * return[3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author: wxq
 * @date 2018-10-16 20:57
 **/


//class TreeNode {
//    int val;
//    TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//}

public class No6_7_PostorderOrPreorder_Traversal {

    /*
    * 递归的方法
    * @author wxq
    * @date 2018-10-16
    * */
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null){
            ArrayList arrayList = new ArrayList();
            arrayList.add(root.val);
            return arrayList;
        }
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        left.addAll(right);
        left.add(root.val);
        return left;
    }

    /*
    * 后序遍历 左右根, 先进行根右左, 再反转回来
    * @author wxq
    * @date 2018-10-16
    * */
    public static ArrayList<Integer> postorderTraversal_1(TreeNode root){
        ArrayList<TreeNode> stack = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode t = stack.remove(stack.size()-1);
            res.add(t.val);
            if(t.left != null){
                stack.add(t.left);
            }
            if(t.right != null){
                stack.add(t.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /*
    * 非递归先序
    * @author wxq
    * @date 2018-10-16
    * */
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return  new ArrayList<>();
        }

        ArrayList<TreeNode> stack = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.remove(stack.size()-1);
            res.add(node.val);
            if(node.right != null){
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rNode1 = new TreeNode(2);
        TreeNode lNode1 = new TreeNode(3);
        root.right = rNode1;
        rNode1.left = lNode1;
        System.out.println(postorderTraversal_1(root));
        System.out.println(preorderTraversal(root));
    }
}
