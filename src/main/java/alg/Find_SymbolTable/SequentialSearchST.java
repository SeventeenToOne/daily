package alg.Find_SymbolTable;



/**
 * @program: algorithms
 * @description:  无序链表顺序查找
 * @author: wxq
 * @date 2019-04-19 11:05
 **/
public class SequentialSearchST<Key, Value> extends ST{
    private Node fist;

    private class Node{
        // 链表结构定义
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.value = val;
            this.next = next;
        }

    }
    
    
    public Value get(Key key){
        for (Node i = fist; i != null ; i = i.next) {
            if(key.equals(i.key)){
                return i.value;
            }
        }
        return null;
    }


    public void put(Key key, Value value){
        //查找给定的键,找到则更新该值,否则在表中新建节点
        for (Node x = fist; x != null ; x = x.next) {
            if(x.key.equals(key)){
                x.value = value;
                return;
            }
        }
        fist = new Node(key, value, fist);
    }



}
