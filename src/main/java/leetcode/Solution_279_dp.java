package leetcode;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-21 09:12
 **/
public class Solution_279_dp {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; 0 <= i - j*j; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    static class Node{
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return " " + key + " " + value;
        }
    }
    // 用图的广度优先便利解决该题目
    public static int numSquaresBFS(int n) {
        //建立一个队列存放广度优先遍历访问的节点
//        List<Map<Integer, Integer>> q = new LinkedList<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        //建立一个访问数组,防止重复的访问
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        q.addLast(new Node(n, 0));
        visited[n] = true;
        
        while (!q.isEmpty()){
            Node node = q.pop();
            System.out.println(node);
            for (int i = 1; 0 <= node.key-i*i; i++) {
                if (node.key-i*i == 0){
                    return node.value +1;
                }
                if (!visited[node.key-i*i]){
                    q.addLast(new Node(node.key-i*i, node.value+1));
                    visited[node.key-i*i] = true;
                }

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquaresBFS(12));
    }
}
