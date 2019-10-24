package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_103 {
    static boolean POS_ORDER = true;
    static boolean REVER_ORDER = false;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean order = POS_ORDER;

        if(root == null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLayer = new LinkedList<>();

            if(order == POS_ORDER){

                for (int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    curLayer.add(node.val);

                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                }

                order = REVER_ORDER;

            }else {

                for (int i = size; i > 0; i--){
                    TreeNode node = queue.poll();
                    curLayer.add(0, node.val);

                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                }

                order = POS_ORDER;
            }

            res.add(curLayer);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
