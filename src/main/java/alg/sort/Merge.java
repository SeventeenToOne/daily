package alg.sort;

import ThinkInJava.泛型.util.Generators;
import alg.Example;

import java.util.ArrayList;
import java.util.List;

/*
* 自顶向下的归并算法
* 排序所需要的时间跟NlogN成正比
* 主要缺点是所需要的额外空间和N成正比
*
* p170
*
* @author wxq
* @date 2018-5-3
* */
public class Merge extends SortTemplate{
    protected static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        // Comparable[] aux = new Comparable[a.length]
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;

        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid); // 左半边排序
        sort(a, mid+1, hi); // 右半边排序
        merge(a, lo, mid, hi);
    }
    // 原地归并
    public static void merge(Comparable[] a, int lo, int mid, int hi){

        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi ; k++){
            aux[k] = a[k];
        }

        for(int k = lo; k <= hi; k++){
            if (i > mid)                            a[k] = aux[j++];
            else if (j > hi)                        a[k] = aux[i++];
            else if(less(aux[j], aux[i]))           a[k] = aux[j++];
            else                                    a[k] = aux[i++];
        }

//        for(int k = lo; k <= hi ; k++){
//            aux.add(a[k]);
//        }
//
//        for(int k = lo; k <= hi; k++){
//            if (i > mid)                            a[k] = aux.get(j++);
//            else if (j > hi)                        a[k] = aux.get(i++);
//            else if(less(aux.get(j), aux.get(i)))   a[k] = aux.get(j++);
//            else                                    a[k] = aux.get(i++);
//        }

    }


    public static void main(String[] args){
//        List<Example> list = new ArrayList<>();
//        Generators.fill(list, Example.generator(), 1000000);
//        Example[] examples = new Example[list.size()];
//        list.toArray(examples);
//        long startTime = System.currentTimeMillis();
//        Merge.sort(examples);
//        System.out.println(Merge.isSorted(examples));
//      //  Merge.show(examples);
//        long endTime = System.currentTimeMillis();
//        long mergeTime = (endTime - startTime);
//        System.out.println("Merge : " + mergeTime);
//
//
//        list.toArray(examples);
//        startTime = System.currentTimeMillis();
//        Shell.sort(examples);
//        System.out.println(Shell.isSorted(examples));
//        endTime = System.currentTimeMillis();
//        long shellTime = (endTime - startTime);
//        System.out.println("Shell : " + shellTime);
    }
}
