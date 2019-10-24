package alg.Find_SymbolTable;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @program: algorithms
 * @description: 二叉查找树
 * @author: wxq
 * @date 2019-04-26 10:27
 **/
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int Num;

        public Node(Key k, Value val, int num){
            key = k; value = val; Num = num;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }else {
            return x.Num;
        }
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node node, Key key){
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.value;

    }

    public void put(Key key, Value value){
        // 如果 是这样会发生什么情况 当root为空的时候,插入完数据root仍未空
        //put(root, key, value);

        // root = 的主要作用是在于当root为空的时候能够正确赋值, 增加代码可读性
        root = put(root, key, value);
    }

    public void putNotRoot(Key key, Value value){
        put(root, key, value);
    }
    private Node put(Node node, Key key, Value value){
        // 找到插入的节点
        if (node == null) return new Node(key, value, 1);
        // 寻找插入的节点
        int cmp = key.compareTo(node.key);
        if (cmp < 0 ) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;

        // 更新当前节点数目
        node.Num = size(node.left) + size(node.right) + 1;
        return node;
    }

    // P254 二叉树中,关于有序表的相关操作
    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null){
            return x;
        }
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if (x.right == null){
            return x;
        }
        return max(x.right);
    }
    /**
     * 找出出小于等于key的最大键
     *
     * @param key
     * @return Key
     * @author wxq
     * @date 2019-5-5
    */
    public Key floor(Key key){
        Node x =  floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key){
        if(x == null){
            return null;
        }
        Node t = null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        //注意 比根节点小, 说明一定在左子树上
        if(cmp < 0){
            return floor(x.left, key);
        }
        if (cmp > 0){
            t = floor(x.right, key);
        }

        if(t == null){
            return x;
        }else {
            return t;
        }
    }

    // 从零开始, 查找排名为k的键
    public Key select(int k){
        Node x = select(root, k);
        if (x == null) return  null;
        return x.key;
    }

    private Node select(Node x, int k){
        if (x == null) return null;
        int t = size(x.left);
        if(t < k) return select(x.right, k-t-1);
        else if (t > k) return select(x.left, k);
        else return x;
    }

    /**
     * 查找 小于key的键的数量
     * @param key
     * @return int
     * @author wxq
     * @date 2019-5-5
    */
    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node x, Key key){
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return rank(x.right, key) + size(x.left) + 1;
        else if (cmp < 0) return  rank(x.left, key);
        else return size(x.left);
    }

    // 删除操作 二叉树中最为复杂的部分

    // 删除树中最小的节点,注意,删除后要更新整个树以及每个节点的子节点数
    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x == null) return null;
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.Num = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除节点key, 当key节点,左右子树都不为空时, 用其后继节点作为新的节点,(P260 更好的方式是 前驱节点和后继节点随机选择)
     * 即时删除
     * @param key
     * @return void
     * @author wxq
     * @date 2019-5-5
    */
    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if( x == null ) return  null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            // 使用t.right 而不是x.right
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        // 更新操作对所有判断进行.
        x.Num = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi){
        ArrayList<Key> q = new ArrayList<>();
        keys(root, lo, hi, q);
        return q;
    }

    private void keys(Node x, Key lo, Key hi, List q){
        if( x == null ) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0) keys(x.left, lo, hi, q);
        if (cmplo <= 0 && cmphi >= 0) q.add(x.key);
        if (cmphi > 0) keys(x.right, lo, hi, q);
    }

    public static void main(String[] args) {
        BST<Integer, Integer> st = new BST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.putNotRoot(3, 3);
        st.putNotRoot(4, 4);
        st.putNotRoot(5, 4);
        for (Integer integer : st.keys()) {
            System.out.println(integer);
        }
        System.out.println(st.size());
    }
}
