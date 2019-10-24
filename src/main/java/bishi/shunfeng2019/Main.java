package bishi.shunfeng2019;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();


        HashSet<Integer> lans = new HashSet<>();
        HashMap<Integer, Integer> peoples = new HashMap<>(); // 修改
        HashMap<Integer, Integer> tempPeo = new HashMap<>(); // 修改
        int t = 0;// 修改

        for (int i = 0; i < k; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            // 修改
            if(peoples.containsKey(u) && peoples.get(u) != v){
                tempPeo.put(u, v);
            }else{
                peoples.put(u, v);
                lans.add(v);
            }
            // 修改


        }
        int peoNum = peoples.size();
        int diffId = Integer.MAX_VALUE;
        if(!tempPeo.isEmpty()){
            for (Integer u : tempPeo.keySet()) {
                int curLan = tempPeo.get(u);
                if(peoples.containsValue(curLan)){
                    t++;
                }else {
                    peoples.put(diffId--, curLan);
                }
            }
        }

        int lanNum = m == 0 || k == 0 ? 0 : lans.size() - 1 - t; // 修改
        int learnNum = n - peoNum + lanNum;
        System.out.println(learnNum);

    }
}
/*
3 3 2
2 3
3 1

3 3 0

3 3 3
1 1
2 2
3 3

3 1 3
1 1
2 1
3 1

3 1 1
3 2

3 3 4
1 1
1 2
2 2
3 1

3 3 4
1 1
1 2
2 2
2 3


3 3 4
1 2
1 1
2 2
3 1

3 3 5
1 2
1 1
1 3
2 1
2 2

3 5 5
1 2
1 1
1 3
2 4
3 4

100000 5 5
1 2
1 1
1 3
2 4
3 4

3 5 6
1 2
1 1
1 3
2 2
3 4
1 4
* */
