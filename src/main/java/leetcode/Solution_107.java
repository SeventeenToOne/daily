package leetcode;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return null;
        }

        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                arrayList.add(0, node.val);
            }

            res.add(arrayList);
        }

        return res;

    }

    public static void main(String[] args) {

    }
}
