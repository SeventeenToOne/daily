package alg.sort;

import ThinkInJava.泛型.util.Generators;
import alg.Example;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

/*
* 快速排序的递归实现
* 实现快速排序时，需要注意一下几点
* 1)原地切分，如果使用一个辅助数组，我们可以很容易成功的实现切分，但是将切分后的数组复制回去的开销也许会使我们得不偿失。
* 如果讲空数组创建在递归的切分中，会大大降低排序的速度。
* 2）别越界，对partition实现进行明确的检测来预防这个情况
* 3）保持随机性  StdRandom.shuffle(a);
* 4）终止循环，在循环结束需要格外小心。最常见额错误是没有考虑到数组中可能包含和切分元素的值相同的其他元素
* 5）处理切分元素值有重复的情况（关键）左侧扫描最好是在遇到大于等于切分元素值时停下，右侧扫描是遇到小于等于切分元素值的元素停下（练习2.3.11）
* p182
*
*
*
* @author wxq
* @date 2018-5-31
* */
public class Quick  extends SortTemplate{

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){

        if(hi <= lo) return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);

    }

    private static int partition(Comparable[] a, int lo, int hi){

        Comparable v = a[lo];
        int i = lo;
        int j = hi+1;

        while(true){
            while(less(a[++i], v))  if(i == hi) break;
            while(less(v, a[--j]))  if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args){
        List<Example> list = new ArrayList<>();
        Generators.fill(list, Example.generator(), 10000000);
        Example[] examples = new Example[list.size()];
        list.toArray(examples);
        System.out.println(isSorted(examples));
        long startTime = System.currentTimeMillis();
        sort(examples);
        System.out.println(isSorted(examples));
        long endTime = System.currentTimeMillis();
        long mergeTime = (endTime - startTime);
        System.out.println("Quick : " + mergeTime);

    }

}
