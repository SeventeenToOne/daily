package bishi.xiaomi2019;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();

        TreeNode tree = new TreeNode();
        tree.build("1(2(3,4(,5)),6(7,))");

        System.out.println(tree.Order());

    }


}

class TreeNode{
    Node root;
    class Node{
        Node left;
        Node right;
        char val;

        public Node(char val){
            this.val = val;
        }
    }

    StringBuilder res = new StringBuilder();

    public String Order(){
        order(root);
        return res.toString();
    }

    private void order(Node node){
        if(node == null){
            return;
        }

        if(node.left != null){
            order(node.left);
        }
        res.append(node.val);

        if(node.right != null){
            order(node.right);
        }

    }


    public void build(String str){
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<Node> queueNode = new LinkedList<>();

        root = new Node(str.charAt(0));

        queue.offer(str.substring(1, str.length()));
        queueNode.offer(root);

        while(!queue.isEmpty()){
            int size = queueNode.size();

            for (int i = 0; i < size; i++) {
                Node curNode = queueNode.poll();
                String curStr = queue.poll();
                if(curStr.contains("(") || curStr.contains(")")){
                    // 去掉括号
                    curStr = curStr.substring(1, curStr.length()-1);
                    System.out.println(curStr);
                    // 7,    ,7    6(),7()
                    int spitIndex = 0;
                    char leftNode = 't', rightNode = 't';
                    boolean passDot = false, leftFalg = false, rightFalg = false;
                    //计算括号
                    int num = 0;
                    for (int k = 0; k < curStr.length(); k++) {
                        if(curStr.charAt(k) <= '9' && curStr.charAt(k) >= '0'){
                            if(!leftFalg && !passDot){
                                leftNode = curStr.charAt(k);
                                leftFalg = true;
                            }

                            if(passDot && !rightFalg){
                                rightNode = curStr.charAt(k);
                                rightFalg = true;
                            }
                        }
                        if(num == 0 && curStr.charAt(k) == ','){
                            spitIndex = k;
                            passDot = true;
                        }

                        if(curStr.charAt(k) == '('){
                            num++;
                        }

                        if(curStr.charAt(k) == ')'){
                            num--;
                        }

                        if(passDot && leftFalg && rightFalg){
                            break;
                        }
                    }

                    if(1 < spitIndex && leftNode != 't'){
                        String leftStr = curStr.substring(1, spitIndex);
                        System.out.println("leftStr : " + leftStr);
                        curNode.left = new Node(leftNode);
                        queue.offer(leftStr);
                        queueNode.offer(curNode.left);
                    }else if(leftNode != 't'){
                        curNode.left = new Node(leftNode);
                    }

                    if( spitIndex + 2 < curStr.length() && rightNode != 't'){
                        String rightStr = curStr.substring(spitIndex + 2, curStr.length());
                        System.out.println("rightStr : " + rightStr);
                        curNode.right = new Node(rightNode);
                        queue.offer(rightStr);
                        queueNode.offer(curNode.right);
                    }else if(rightNode != 't'){
                        curNode.right = new Node(rightNode);
                    }

                }
            }// for size


        }
    }
}

/*
1(2(3,4(,5)),6(7,))
* */
