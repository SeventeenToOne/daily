package alg.sort;

import ThinkInJava.泛型.util.Generators;
import alg.Example;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

/*
* 三向切分的快速排序 ---> 对于大量的重复元素的数组时，这种方法比标准的快速排序的效率高的多 ex..  n:50000000 Quick3 : 9294; Quick : 29066 Quick3.1 : 2693
* 从左到右遍历数组一次，维护一个指针lt使得
* a[lo..lt-1]中的元素都小于v,
* 一个指针gt使得a[gt+1..hi]中的元素都大于v，
* 一个指针使得a[lt..i-1]中的元素都等于v.
* a[i..gt] 中的元素还都未确定
*
*  a[i]小于v, 将a[lt]和a[i]交换，将lt和i加1
* a[i]大于v, 将a[gt]和a[i]交换, 将gt减1
* a[i]等于v, 将i加1
*
* P189
*
* @author wxq
* @date 2018-6-4
* */
public class Quick3way extends SortTemplate {
    public static void sort(Comparable[] a){
        int N = a.length;
        StdRandom.shuffle(a);
        sort(a, 0, N-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if( hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0 ) exch(a, lt++, i++);
            else if (cmp > 0 ) exch(a, i, gt--);
            else i++;

        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    /*
    * 小范围的数组用插入代替快速
    * */
    private static void sortV1(Comparable[] a, int lo, int hi){
        if( hi <= lo) return;
        if((hi - lo) <= 7 ){
            Insertion.sort(a, lo, hi);
        }
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0 ) exch(a, lt++, i++);
            else if (cmp > 0 ) exch(a, i, gt--);
            else i++;

        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    public static void main(String[] args){
        /*
        * quick和quick3速度比较
        * */
        List<Example> list = new ArrayList<>();
        Generators.fill(list, Example.generator(), 50000000);
        Example[] examples = new Example[list.size()];
        list.toArray(examples);
        System.out.println(isSorted(examples));
        long startTime = System.currentTimeMillis();
        sort(examples);
        System.out.println(isSorted(examples));
        long endTime = System.currentTimeMillis();
        long mergeTime = (endTime - startTime);
        System.out.println("Quick3 : " + mergeTime);

        startTime = System.currentTimeMillis();
        Quick.sort(examples);
        System.out.println(isSorted(examples));
        endTime = System.currentTimeMillis();
        mergeTime = (endTime - startTime);
        System.out.println("Quick : " + mergeTime);


        startTime = System.currentTimeMillis();
        sortV1(examples, 0, examples.length-1);
        System.out.println(isSorted(examples));
        endTime = System.currentTimeMillis();
        mergeTime = (endTime - startTime);
        System.out.println("Quick3.1 : " + mergeTime);
    }
}
