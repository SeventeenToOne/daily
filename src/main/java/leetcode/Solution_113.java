package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_113 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return res;
        }
        Preorder(root, 0, sum);
        return res;

    }

    public void Preorder(TreeNode node, int curValue, int sum){
        stack.push(node.val);
        curValue = node.val + curValue;

        if(curValue == sum && node.left == null && node.right == null){
            // print
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = stack.size()-1; i>=0 ; i--) {
                arrayList.add(stack.get(i));
            }
            res.add(arrayList);
        }

        if(node.left != null){
            Preorder(node.left, curValue, sum);
        }

        if(node.right != null){
            Preorder(node.right, curValue, sum);
        }

        stack.pop();

    }

    public static void main(String[] args) {

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

// Definition for a binary tree node.

