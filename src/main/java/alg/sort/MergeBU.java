package alg.sort;

import ThinkInJava.泛型.util.Generators;
import alg.Example;

import java.util.ArrayList;
import java.util.List;

/*
* 自底向上的归并排序
* 比较适合用链表组织的数据只需要重新组织链表链接就能将链表原地排序
* 当数据长度为2的幂时，自底向上和自顶向下的归并所用的比较次数和数据访问次数正好相同，只是顺序不同
* P175 算法
* @author wxq
* @date 2018-5-30
* */
public class MergeBU extends Merge {
    // 使用父类的 aux数组，用来暂时存放数据，修改Merge　aux权限修改为Protected
    // private static Comparable[] aux;

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for(int lo = 0; lo < N - sz; lo += sz + sz){
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }



    public static void main(String[] args){

//        List<Example> list = new ArrayList<>();
//        Generators.fill(list, Example.generator(), 10000000);
//        Example[] examples = new Example[list.size()];
//        list.toArray(examples);
//        long startTime = System.currentTimeMillis();
//        sort(examples);
//        System.out.println(isSorted(examples));
//        //  Merge.show(examples);
//        long endTime = System.currentTimeMillis();
//        long mergeTime = (endTime - startTime);
//        System.out.println("MergeBU : " + mergeTime);
//        for (int i = 0; i < 100; i++) {
//            System.out.print(examples[i] + " ");
//        }
    }


}
