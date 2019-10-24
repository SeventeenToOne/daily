package niukewang.leecode;

/**
 * @program: algorithms
 * @description:
 * 题目描述
 *
 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 *
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 * @author: wxq
 * @date 2018-10-26 20:59
 **/
public class No16_canCompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int len = cost.length;

        for (int i = 0; i < len; i++) {
            int stock = 0;
            int circultlen = len;
            int j = i ;
            boolean flag = true;
            while (circultlen > 0){
                stock += gas[j%len];
                System.out.println("stock " + stock + " cost " + j%len + " " + cost[j%len]);
                if((stock - cost[j%len]) < 0){
                    flag = false;
                    break;
                }
                stock = stock - cost[j%len];
                System.out.println("after stock " + stock);
                j++;
                circultlen--;
            }
            System.out.println(circultlen);
            if (circultlen == 0 && flag){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2, 4}, new int[]{3, 4}));
    }
}
