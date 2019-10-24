package alg.sort;


import ThinkInJava.泛型.util.Generators;
import alg.Example;

import java.util.ArrayList;
import java.util.List;

/*
* 插入排序
* p157
*
* @author wxq
* @date 2018-4-21
* */
public class Insertion extends SortTemplate{

    public static void  sort(Comparable[] a){

        int N = a.length;
        for(int i =1; i < N; i++){
            // 将a[i] 插入到 a[i-1], a[i-2] .... 中
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
        }
    }

    /*
    * 指定范围的插入排序可以用于优化递归类排序算法，用于小范围的数据排序
    * 升序
    * 数组排序范围，包括lo和hi ,例如 lo = 0, hi = 2; a[0], a[1], a[2]
    * @date 2018-6-4
    * */
    public static void sort(Comparable[] a, int lo, int hi){

        for (int i = lo; i<=hi; i++){
            for(int j = i + 1; j>0 && less(a[j], a[j-1]); j-- ){
                exch(a, j, j-1);
            }
        }

    }


    public static void main(String[] args){
        List<Example> list = new ArrayList<>();
        Generators.fill(list, Example.generator(), 1000000);
        Example[] examples = new Example[list.size()];
        list.toArray(examples);


//        for (int i = 0; i < examples.length; i++) {
//            System.out.print(examples[i] + " ");
//        }
//        System.out.println();
        sort(examples);
        System.out.println(isSorted(examples));
        show(examples);
    }
}
