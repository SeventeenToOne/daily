package alg.Find_SymbolTable;

import com.sun.org.apache.regexp.internal.RE;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @program: algorithms
 * @description: 红黑树的实现 P281
 * @author: wxq
 * @date 2019-05-05 14:51
 **/
public class RedBlackBST<Key extends Comparable<Key>, Value>{
    private Node root;
    // 将true表示为red, false表示为black
    private static boolean RED = true;
    private static boolean BLACK = false;

    // 节点定义
    private class Node{
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        Node(Key key, Value value, int N, boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    /**
     * 判断当前节点是否是红节点, 如果当前节点为空, 返回false
     * @param x
     * @return boolean
     * @author wxq
     * @date 2019-5-5
    */
    private boolean isRED(Node x){
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node x){
        if(x == null) return null;
        Node t = x.right;
        x.right = t.left;
        t.left = x;
        t.color = x.color;
        x.color = RED;
        // 更新节点数量
        t.N = x.N;
        x.N = size(x.left) + size(x.right) + 1;
        return t;
    }

    private Node rotateRight(Node x){
        if(x == null) return null;
        Node t = x.left;
        x.left = t.right;
        t.right = x;
        t.color = x.color;
        x.color = RED;
        // update node num;
        t.N = x.N;
        x.N = size(x.left) + size(x.right) + 1;
        return t;
    }

    private void flipColors(Node h){
        h.left.color = !h.left.color;
        h.right.color =  !h.right.color;
        h.color = !h.color;
    }

    private int size(Node x){
        if (x == null) return 0;
        return x.N;
    }


    public void put(Key key, Value value){
        root = put(root, key, value);
        // 关键
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value value){
        if (x == null) return new Node(key, value, 1, RED);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, value);
        else if(cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;

        if (isRED(x.right) && !isRED(x.left)) x = rotateLeft(x);
        if (isRED(x.left) && isRED(x.left.left)) x = rotateRight(x);
        if (isRED(x.left) && isRED(x.right)) flipColors(x);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
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

    private boolean isEmpty(){
        return root == null;
    }

    // 删除最大值,最小值,以及删除某一元素 以及相关操作

    /**
     *  假设结点h为红色, h.left和h.left.left为黑色
     *  将h.left或者h.left的子结点之一变红
     *
     * @param h
     * @return alg.Find_SymbolTable.RedBlackBST<Key,Value>.Node
     * @author wxq
     * @date 2019-5-7
    */
    private Node moveRedLeft(Node h){

        flipColors(h);
        // 当前子树都是左倾的红黑树,不存在h.right.right为红节点
        if (isRED(h.right.left)){
            // 存在兄弟结点为3-节点, 从兄弟结点借一个结点,并且重置h的颜色
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            //关键步骤
            flipColors(h);
        }
        // else 如果兄弟节点 也为2-节点, 即 h.left, h , h.right 都为2-节点, 将这三个结点用红色结点连接以来生成暂时的4-结点
        // 后续通过平衡操作,拆分4-结点
        return h;
    }

    /**
     * 假设结点h为红色, h.right和h.right.left为黑色
     * 将h.right或者h.right的子结点之一变红
     * @param h
     * @return alg.Find_SymbolTable.RedBlackBST<Key,Value>.Node
     * @author wxq
     * @date 2019-5-7
    */
    private Node moveRedRight(Node h){
        flipColors(h);

        if (isRED(h.left.left)){
            //如果h.left 是3-结点,则从兄弟结点借一个结点到右边
            h = rotateRight(h);
            flipColors(h);
        }

        return h;
    }

    private Node balance(Node x){
        if (isRED(x.right)) x = rotateLeft(x);

        if (isRED(x.left) && isRED(x.left.left)) x = rotateRight(x);
        if (isRED(x.left) && isRED(x.right)) flipColors(x);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    public void deleteMin(){

        // 不知道为什么做此操作
        // 保证每次在moveRedLeft时,结点h都为红色, 防止最后是红黑树左倾时出错
        if(!isRED(root.left) && !isRED(root.right)){
            root.color = RED;
        }

        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;

    }

    private Node deleteMin(Node h){
        // 找到最小值,删除,返回null
        if (h.left == null){
            return null;
        }
        // 如果h的左子树是一个2-结点, 从父节点或者兄弟节点借节点过来
        if (!isRED(h.left) && !isRED(h.left.left)){
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void deleteMax(){

        if(!isRED(root.left) && !isRED(root.right)){
            root.color = RED;
        }
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h){
        // 如果当前h节点为最大值, 左结点为红色, 没有右子树, 则通过旋转, 方便删除时,直接赋值为null
        if (isRED(h.left)){
            h = rotateRight(h);
        }

        // 找到最大值,删除,返回null
        if (h.right == null){
            return null;
        }

        if (!isRED(h.right) && !isRED(h.right.left)){
            h = moveRedRight(h);
        }
        h.right = deleteMax(h.right);
        return balance(h);

    }

    public void delete(Key key){
        // 判断key是否是合法值

        //
        if(!isRED(root.left) && !isRED(root.right)){
            root.color = RED;
        }
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, Key key){
        if (key.compareTo(h.key) < 0){
            // 防止下一结点为2-结点
            if(!isRED(h.left) && !isRED(h.left.left)){
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        }else {
            // 操作同删除最大结点
            if (isRED(h.left)){
                h = rotateRight(h);
            }
            if (key.compareTo(h.key) == 0 && h.right == null){
                return null;
            }
            if (!isRED(h.right) && !isRED(h.right.left)){
                h = moveRedRight(h);
            }

            // 如果找到key, 并且结点位于树的内部.不是树底
            if (key.compareTo(h.key) == 0){
                // 将右子树的最小值 赋值给当前结点, 并删除最小值
                h.value = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMax(h.right);
            }else {
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }

    // 其他操作

    /**
     * Returns the smallest key in the symbol table.
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    // the smallest key in subtree rooted at x; null if no such key
    private Node min(Node x) {
        // assert x != null;
        if (x.left == null) return x;
        else                return min(x.left);
    }

}
