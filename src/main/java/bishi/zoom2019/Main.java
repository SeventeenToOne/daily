package bishi.zoom2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String  str = scan.next();
        String[] arr = str.split(",");
        double[] array = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Double.valueOf(arr[i]);
        }


        double[] res = new double[array.length];
        double maxValue = Double.MIN_VALUE;
        Arrays.fill(res, 0);

        res[0] = array[0];
        for (int i = 1; i < array.length; i++) {
           double value = array[i];
           double curMaxValue = value;
           for(int j = i-1; j>=0; j--){
               value = value * array[j];
               if(curMaxValue < value){
                   curMaxValue = value;
               }
           }
           if(maxValue < curMaxValue){
               maxValue = curMaxValue;
           }
           res[i] = curMaxValue;
        }

        System.out.println(maxValue);

    }
}
