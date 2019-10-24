package alg.sort;

import ThinkInJava.泛型.util.Generator;
import ThinkInJava.泛型.util.Generators;
import alg.Example;

import javax.print.attribute.standard.SheetCollate;
import java.util.ArrayList;
import java.util.List;

/*
* 希尔排序
* 对于中等大小的数组来说，运行时间是可以接受的。
* 算法运行时间不到平方级
*
* p163
*
* @auhor wxq
* @date 208-5-3
* */
public class Shell<T> extends SortTemplate{

    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N/3) h = h * 3 + 1; // 1, 4, 13, 40, 121

        while(h >= 1){
            //相当于做h队的希尔排序
            for(int i = h; i < N; i++){
                // 将a[i] 插入到a[i-h], a[i-2*h], a[i-3*h] ... 之中
                for(int j = i; j >= h && less(a[j], a[j-h]) ; j -= h){
                    exch(a, j, j-h);
                }
            }

            h = h/3;
        }

    }

    public static void main(String[] args){
        List<Example> list = new ArrayList<>();
        Generators.fill(list, Example.generator(), 10000000);
        Example[] examples = new Example[list.size()];
        list.toArray(examples);
        long startTime = System.currentTimeMillis();
        Shell.sort(examples);
        long endTime = System.currentTimeMillis();
        long shellTime = (endTime - startTime);
        System.out.println("Shell : " + shellTime);

        // Insertion test

//        list.toArray(examples);
//        System.out.println(Insertion.isSorted(examples));
//        startTime = System.currentTimeMillis();
//        Insertion.sort(examples);
//        endTime = System.currentTimeMillis();
//        long insertionTime =  (endTime - startTime);
//        System.out.println("Insertion : " + insertionTime);
//        System.out.println(insertionTime*1.0/shellTime);
    }
}
