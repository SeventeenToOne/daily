package bishi;

import java.util.Scanner;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-07-15 19:36
 **/
public class shenxinfu {
    public static void main(String[] args) {
        int[] array = {3, 1, 2, 4};
        System.out.println(minNumberInRotateArray(array));
    }

    /**
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;  // 数组长度为0， 返回0
        int left = 0;   // 开始处理的第一个位置
        int right = array.length - 1;   // 开始处理的最后一个位置
        int mid = left;   // 设置初始位置
        // 确保left在前面排好序的位置，right在后面排好序的位置
        while(array[left] >= array[right]) {
            // 当处理数据只有两个返回后一个结果
            if(right - left == 1) {
                return array[right];
            }
            // 取中间的位置
            mid = (left + right) / 2;
            // 如果三个数相等，顺序查找最小值
            if((array[left] == array[mid]) && (array[left] == array[right]) && (array[mid] == array[right]) ) {
                return minNum(array, left, right);
            } else if(array[left] >= array[mid]) { // 中间数据在后半部分，最小值在当前mid前面
                right = mid;
            } else {  // 中间数据在前半部分，最小值在当前mid后面
                left = mid;
            }
        }
        return array[mid];
    }

    private static int minNum(int[] array, int left, int right) {
        int min = array[left];
        for(int i=left+1; i<=right; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

}
