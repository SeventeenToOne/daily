package niukewang.XiaoZhao2019;

import java.util.*;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-06-28 21:34
 **/
public class No_1_NiuNIuZhaoGongzuo {
    static class Node implements Comparable<Node>{
        int hard;
        int value;

        public Node(int hard, int value){
            this.value = value;
            this.hard = hard;
        }

        @Override
        public int compareTo(Node x) {
            return  hard - x.hard;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hard=" + hard +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), M = scan.nextInt();
        if (N <= 0 || M <= 0){
            return;
        }


        ArrayList<Node> works = new ArrayList<>(N);
        int[] people = new int[M];
        for (int i = 0; i < N; i++) {
            int hard = scan.nextInt();
            int value = scan.nextInt();
            works.add(new Node(hard, value));
        }
        for (int i = 0; i < M; i++) {
            people[i] = scan.nextInt();
        }
        Collections.sort(works);


        int[] maxValue = new int[N];
        int max = 0;
        TreeMap<Integer, Integer> hardToIndex = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int curValue = works.get(i).value;
            if (curValue > max){
                max = curValue;
            }
            maxValue[i] = max;

            hardToIndex.put(works.get(i).hard, i);
        }


        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int curAbility = people[i];
            int index = hardToIndex.get(hardToIndex.floorKey(curAbility));
            if(index < 0){
                result[i] = maxValue[0];
            }else if (index >= N){
                result[i] = maxValue[N-1];
            }else {
                result[i] = maxValue[index];
            }

        }

        for (int res : result) {
            System.out.println(res);
        }
       // System.out.println(works);
    }
}
