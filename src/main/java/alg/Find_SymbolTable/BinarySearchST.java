package alg.Find_SymbolTable;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithms
 * @description: 算法 P239 基于二分查找的符号表
 * @author: wxq
 * @date 2019-04-25 09:44
 **/
public class BinarySearchST <Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity){
        // 可以实现动态调整数组长度的算法
        keys = (Key[]) new Comparable[capacity];
        values = (Value[])new Object[capacity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public Value get(Key key){
        if (isEmpty()) return  null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            return values[i];
        }
        return null;
    }

    // 基于二分查找查找当前元素位置
    public int rank(Key key){
        int lo = 0, hi = N - 1;
        while (lo <= hi){
            // 致命bug hi-lo / 2 只是两者距离的一半, 不是当前的数组的中间值, 注意
            // int mid = (hi - lo) / 2;

            int mid = lo + (hi - lo) / 2;
            int cmp =key.compareTo(keys[mid]);
//            if (cmp == 0) return mid;
//            if (cmp < 0){
//                hi = mid - 1;
//                continue;
//            }
//            if(cmp > 0){
//                lo = mid + 1;
//                continue;
//            }
            if (cmp < 0) hi = mid - 1 ;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value value){
        int i = rank(key);
        if(i < N && key.compareTo(keys[i]) == 0){
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    // min() max() select(); floor()

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new LinkedList<>();
        System.out.println(rank(lo));
        System.out.println(rank(hi));
        for (int i = rank(lo); i < rank(hi); i++){
            ((LinkedList<Key>) queue).push(keys[i]);
        }
        if(contains(hi)){
            ((LinkedList<Key>) queue).push(hi);
        }
        return queue;
    }

    public boolean contains(Key key){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            return true;
        }
        return false;
    }


}
