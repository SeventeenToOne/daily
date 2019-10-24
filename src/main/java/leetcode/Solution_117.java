package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_117 {
    public Node connect(Node root) {
        if(root.left == null && root.right == null){
            root.next = null;
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> queueLayer = new LinkedList<>();

        ArrayList<Integer> layers = new ArrayList<>();
        ArrayList<Node> res = new ArrayList<>();
        queue.offer(root);
        queueLayer.offer(0);

        res.add(root);
        layers.add(0);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            Integer layer = queueLayer.poll();
            if(node.left != null){
                queue.offer(node.left);
                res.add(node.left);

                layers.add(layer+1);
                queueLayer.offer(layer+1);
            }
            if(node.right != null){
                queue.offer(node.right);
                res.add(node.right);

                layers.add(layer+1);
                queueLayer.offer(layer+1);
            }
        }

        int layer = 0;
        Node preNode = root;
        for (int i = 1; i < layers.size(); i++) {
            int curLayer = layers.get(i);
            Node curNode = res.get(i);
            if(curLayer != layer){
                preNode.next = null;
                preNode = curNode;
                layer = curLayer;
            }else {
                preNode.next = curNode;
                preNode = curNode;
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }




}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static void main(String[] args) {

    }
}

/*
* 117. 填充每个节点的下一个右侧节点指针 II
* */
