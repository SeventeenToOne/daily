package ACMOJ;

import java.util.Scanner;

/*
* @date 2018-6-27
* */
public class HDU1002_lab412_DP {

    /*
    * @param weights 物品重量数组
    * @param values 物品价值数组
    * @param N 物品个数
    * @param capacity 物品背包容量
    * */
    public static int bag(int[] weights, int[] values, int N, int capacity){
        //
        int[][] items = new int[N][capacity + 1];
        //
        for (int i = 0; i < items.length; i++) {
            for (int j = 1; j < items[i].length; j++) {
                items[i][j] = 0;
            }
        }
        //
        for(int i = 1; i <= capacity; i++){
            if(i >= weights[0]){
                items[0][i] = values[0];
            }else {
                items[0][i] = 0;
            }
        }

//        for (int i = 0; i < items.length; i++) {
//            for (int j = 1; j < items[i].length; j++) {
//                System.out.print(items[i][j] + " ");
//            }
//            System.out.println();
//        }
        // weights = {1, 2, 3, 4, 5};
        // values = {5, 4, 3, 2, 1}

        /*
j = 1
1 5 10 10 5 4 3 2  0 1 2 3 4
result:
0 10 10 10 10 10 10 10 10 10 10
0 10 15 15 15 15 15 15 15 15 15
0 10 15 15 19 19 19 19 19 19 19
0 10 15 15 19 19 19 22 22 22 22
0 10 15 15 19 19 19 22 22 22 22
22
j = 0
result:
10 10 10 10 10 10 10 10 10 10 10
10 15 15 15 15 15 15 15 15 15 15
10 15 15 19 19 19 19 19 19 19 19
10 15 15 19 19 19 22 22 22 22 22
10 15 15 19 19 19 22 22 22 22 24
24


1 5 10 5 4 3 2 10  1 2 3 4 0
result:
0 5 5 5 5 5 5 5 5 5 5
0 5 5 9 9 9 9 9 9 9 9
0 5 5 9 9 9 12 12 12 12 12
0 5 5 9 9 9 12 12 12 12 14
0 15 15 19 19 19 22 22 22 22 24
24


        */
        for(int i = 1; i < N; i++){
            for (int j = 1; j <= capacity; j++){
                if( j >= weights[i]){
                    items[i][j] =  (items[i-1][j] > (items[i-1][j-weights[i]] + values[i])) ?
                            items[i-1][j] : (items[i-1][j-weights[i]] + values[i]);
                }else {
                    items[i][j] = items[i-1][j];
                }
            }
        }

//        System.out.println("result:");
//        for (int i = 0; i < items.length; i++) {
//            for (int j = 0; j < items[i].length; j++) {
//                System.out.print(items[i][j] + " ");
//            }
//            System.out.println();
//        }

        return items[N-1][capacity];
    }

    public static void main(String[] args){
//        int[] weights = {1, 2, 3, 4, 5};
//        int[] values = {5, 4, 3, 2, 1};
        int num;

        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();

        while((num--) > 0){
//           System.out.println("num: " + num);
            int N = scan.nextInt();
            int capacity = scan.nextInt();

            int[] weights = new int[N];
            int[] values = new int[N];



            for (int i = 0; i < values.length; i++) {
                values[i] = scan.nextInt();
            }

            for (int i = 0; i < weights.length; i++) {
                weights[i] = scan.nextInt();
                if(weights[i] <  0 ) weights[i] = 0;
            }
            System.out.println(bag(weights, values,  N, capacity));


        }

    }


}





/*
    Bone Collector
    Time Limit : 2000/1000ms (Java/Other)   Memory Limit : 32768/32768K (Java/Other)
        Total Submission(s) : 5   Accepted Submission(s) : 2
        Font: Times New Roman | Verdana | Georgia
        Font Size: ← →
        Problem Description
        Many years ago , in Teddy’s hometown there was a man who was called “Bone Collector”. This man like to collect varies of bones , such as dog’s , cow’s , also he went to the grave …
        The bone collector had a big bag with a volume of V ,and along his trip of collecting there are a lot of bones , obviously , different bone has different value and different volume, now given the each bone’s value along his trip , can you calculate out the maximum of the total value the bone collector can get ?


        Input
        The first line contain a integer T , the number of cases.
        Followed by T cases , each case three lines , the first line contain two integer N , V, (N <= 1000 , V <= 1000 )representing the number of bones and the volume of his bag. And the second line contain N integers representing the value of each bone. The third line contain N integers representing the volume of each bone.
        Output
        One integer per line representing the maximum of the total value (this number will be less than 231).
        Sample Input
        1
        5 10
        1 2 3 4 5
        5 4 3 2 1
        Sample Output
        14
        Author
        Teddy
        Source
        HDU 1st “Vegetable-Birds Cup” Programming Open Contest
*/
