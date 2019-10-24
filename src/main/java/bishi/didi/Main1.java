package bishi.didi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-09-18 20:41
 **/
public class Main1 {
    //返回 装有回字符串s的全排列的List对象
    public static List<String> byTraverse(String s){
        char[] chArr = s.toCharArray();
        List<String> list = new LinkedList<String>();
        byTraverse0(chArr, 0, list);
        return list;
    }


    private static void byTraverse0(char[] arr, int left, List<String> list){
        if(left >= arr.length-1){
            list.add(new String(arr));
            return;
        }

        //用于记录交换到left下标的每一个元素，防止计算重复的排列
        HashSet<Character> hs = new HashSet<Character>();

        for(int i = left; i < arr.length; i++){
            //arr[left]后面的每一个元素arr[i]都和arr[left]交换
            swap(arr, left, i);
            if(!hs.contains(arr[left])){
                hs.add(arr[left]);
                byTraverse0(arr, left+1, list);
            }
            //将left和i交换回来，防止遗漏，重复
            //已保证下一个交换到left下标的是未交换过的元素
            swap(arr, left, i);
        }
    }
    /*=================================================*/

    //返回 装有大于等于字符串s的全排列的List对象
    public static List<String> byNext(String s){
        char[] arr = s.toCharArray();
        List<String> list = new LinkedList<String>();
        list.add(s);

        while(next(arr)){
            list.add(new String(arr));
        }
        return list;
    }

    private static boolean next(char[] arr){
        boolean hasNext = false;
        int i;
        for(i = arr.length-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                hasNext = true;
                break;
            }
        }

        //如果所有元素是从大到小排列，说明是最大的字符串
        if(!hasNext){
            return false;
        }

        //从i+1的下标往后找（必定是单调递减）,找一个比arr[i]大的集合中最小的一个
        int j;
        for(j = i+1; j < arr.length; j++){
            if(arr[j] <= arr[i]){
                break;
            }
        }
        j--;

        //交换这两个元素，然后逆序i+1以后的所有元素
        swap(arr, i, j);
        reverse(arr, i+1, arr.length-1);

        return true;
    }

    private static void reverse(char[] arr, int from, int to){
        for(int i = from, j = to; i < j; i++, j--){
            swap(arr, i, j);
        }
    }

    /*=================================================*/

    private static void swap(char[] chArr, int i, int j){
        char t = chArr[i];
        chArr[i] = chArr[j];
        chArr[j] = t;
    }

    public static void main(String[] args){
        List<String> list1 = byNext("12333");
        int count = 0;
        for (String s : list1) {
            char[]  chars =  s.toCharArray();
            char t = chars[0];
            for (char aChar : chars) {
//                if(){
//
//                }
            }
        }
        System.out.println(list1);
        System.out.println(list1.size());

        System.out.println();

        List<String> list2 = byTraverse("1233");
        System.out.println(list2);
        System.out.println(list2.size());
    }

}
