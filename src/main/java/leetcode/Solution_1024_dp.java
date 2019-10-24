package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-27 21:56
 **/
public class Solution_1024_dp {
    static class Node implements Comparable<Node>{
        int left;
        int right;

        Node(int left, int right){
            this.left = left;
            this.right = right;
        }


        @Override
        public int compareTo(Node node) {
            if (this.left < node.left){
                return -1;
            }else if (this.left > node.left){
                return 1;
            }else {
                if (this.right < node.right){
                    return -1;
                }else {
                    return 1;
                }
            }
        }
    }

    public static int videoStitching(int[][] clips, int T) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < clips.length; i++) {
            list.add(new Node(clips[i][0], clips[i][1]));
        }
        Collections.sort(list);


        int[] dp = new int[101];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 666666;
        }

        for (int i = 0; i < list.size(); i++) {
            // for
            dp[list.get(i).right] = Math.min(dp[list.get(i).left]+1, dp[list.get(i).right]);
            for (int j = 1; j < list.get(i).right; j++){
                dp[j] = Math.min(dp[list.get(i).right], dp[j]);
            }
        }


//        for (int i : dp) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        return dp[T] == 666666? -1: dp[T];
    }

    public static void main(String[] args) {
        int[][] clips = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int[][] clips1 = new int[][] {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        System.out.println(videoStitching(clips, 10));
        System.out.println(videoStitching(clips1, 9));
    }
}
