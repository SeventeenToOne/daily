package alg.sort;

import alg.Example;

import java.util.Random;

/*
* 基于堆的优先队列
* 堆排序对记录数较少的文件并不值得提倡，但对较大的文件还是很有效的，因为其运行的主要时间在建立初始堆和调整建新堆时进行反复筛选上
*
* 一些变动：
* 多叉堆，例如实现基于用数组表示的完全三叉树构造堆
* 调整数组的大小，例如 添加一个没有参数的构造方法，在insert中添加将数组长度加倍，在delmax中添加将数组长度减半的代码，例如1.3节的栈
*
* P202
*
* @author wxq
* @date 2018.6.6
* */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; // 基于堆的完全二叉树
    private int N = 0; // 存储于pq【1..N】, pq[0] 没有使用

    public MaxPQ(int maxN){
        this.pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null; //防止对象游离
        sink(1);
        return max;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0; // 简便写法
    }

    private void exch(int i, int j){
        Key temp ;
        temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    // 由上至下的堆有序化
    private void sink(int k){

        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(j, k);
            k = j;
        }


    }
    // 由下至上的堆有序化
    private void swim(int k){

        while (k/2 >= 1){
            int i = k/2;
            if(less(i, k)) exch(i, k);
            k = i;
        }

//        while(k>1 && less(k/2, k)){
//            exch(k, k/2);
//            k = k/2;
//        }

    }

    public static void f1(){

    }


    public void show(){
       int n = N;
        for (int i = 1; i <= n; i++) {
            System.out.print(delMax() + " ");

        }
        System.out.println();
    }


    public Key get(int i){
        return pq[i];
    }
    //test
    public static void main(String[] args){

        int N = 100;
        MaxPQ<Example> pq = new MaxPQ<>(N);

        for (int i = 1; i <= N; i++) {
            pq.insert(new Example(new Random().nextInt(10000)));
        }
        pq.show();

    }
}
