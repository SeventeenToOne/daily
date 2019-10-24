package bishi.wangyi;

import java.util.Scanner;

/*
小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
        输入描述:
        第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
        第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
        第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
        输出描述:
        小易这堂课听到的知识点的最大兴趣值。
        示例1
        输入
        复制
        6 3
        1 3 5 2 5 4
        1 1 0 1 0 0
*/
public class Main4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int classNum = scan.nextInt();
        int k = scan.nextInt();
        int[] perVlaue = new int[classNum + 1];
        int[] perAwake = new int[classNum + 1];

        for(int i = 1; i <= classNum; i++){
            perVlaue[i] = scan.nextInt();
        }

        for(int i = 1; i <= classNum; i++){
            perAwake[i] = scan.nextInt();
        }
        int totalValue = 0;
        for(int i = 1; i <= classNum; i++){
            if( perAwake[i] == 1){
                totalValue +=  perVlaue[i];
            }
        }
        //System.out.println("totalValue " + totalValue);

        int kIndex = k, calcuHasAwake = 0, index = 1;
        int hashAwakeLeft = 0, hashAwakeRight = totalValue, maxAwake = 0;

        for(int i = 1; i<= k; i++){
            if( perAwake[i] == 1){
                hashAwakeRight =  hashAwakeRight - perVlaue[i];
            }
            maxAwake += perVlaue[i];

        }
        int maxValue = 0;
        while (index <= classNum){
            int curValue = hashAwakeLeft + hashAwakeRight + maxAwake;
            System.out.println(curValue + " " + hashAwakeLeft + " " + maxAwake + " " + hashAwakeRight);
            if(curValue > maxValue){
                maxValue = curValue;
            }

            if(perAwake[index] == 1){
                hashAwakeLeft += perVlaue[index];
            }

            if(kIndex < classNum){

                if(perAwake[kIndex + 1] == 1){
                    hashAwakeRight = hashAwakeRight -  perVlaue[kIndex + 1];
                }
                //assert hashAwakeRight >= 0;
                maxAwake = maxAwake  + perVlaue[kIndex + 1];
                System.out.println(perVlaue[kIndex + 1]);
                kIndex++;
            }

            maxAwake = maxAwake - perVlaue[index];
            System.out.println(maxAwake + " " + perVlaue[index]);
            index++;
        }
        System.out.println();
        System.out.println(maxValue);

    }
}
