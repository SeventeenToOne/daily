package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class Solution_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }

        TreeNode root = bulidTree(list, 0, list.size()-1);

        return root;
    }

    public TreeNode bulidTree(ArrayList<Integer> list, int left, int right){
        if(right < left){
            return  null;
        }
        int curIndex = (right + left) / 2;
        if(curIndex < 0 || curIndex >= list.size()){
            return null;
        }

        int curVal = list.get(curIndex);
        TreeNode node = new TreeNode(curVal);
        node.left = bulidTree(list, left, curIndex -1);
        node.right = bulidTree(list, curIndex + 1, right);

        return node;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

//109. 有序链表转换二叉搜索树

/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

* */