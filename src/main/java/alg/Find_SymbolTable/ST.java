package alg.Find_SymbolTable;

import javax.security.auth.kerberos.KerberosTicket;

/**
 * @program: algorithms
 * @description: 符号表的抽象类,表明了符号表大致有哪些操作(抽象方法)
 * @author: wxq
 * @date 2019-04-19 09:43
 **/
public class ST<Key extends Comparable<Key>, Value> {


    public void put(Key key, Value value){

    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key){

    }

    public boolean contains(Key key){
        return false;
    }

    public boolean isEmpty(){
        return false;
    }

    public int size(){
        return 0;
    }

    public Key min(){
        return null;
    }

    public Key max(){
        return null;
    }

    /* *
     *返回小于等于key的最大键
     *
     *@author wxq
     *@date 2019-4-19
    */
    public Key floor(Key key){
        return null;
    }

    /* *
     *返回大于等于key的最小键
     *
     *@author wxq
     *@date 2019-4-19
    */
    public Key ceiling(Key key){
        return null;
    }

    /* *
     *小于key键的数量
     *
     *@author wxq
     *@date 2019-4-19
    */
    public int rank(Key key){
        return 0;
    }

    /* *
     *返回排名为k的键
     *
     *@author wxq
     *@date 2019-4-19
    */
    public Key select(int k){
        return null;
    }

    public void deletMin(){
        delete(min());
    }

    public void deleteMax(){
        delete(max());
    }

    /* *
     *返回[lo..hi]之间键的数量
     *
     *@author wxq
     *@date 2019-4-19
    */
    public int size(Key lo, Key hi){
        if (hi.compareTo(lo) < 0){
            return 0;
        }else if (contains(hi)){
            return rank(hi) - rank(lo) + 1;
        }else
            return rank(hi) - rank(lo);

    }

    /* *
     *返回[lo..hi]之间的所有键,已排序
     *
     *@author wxq
     *@date 2019-4-19
     */
    public Iterable<Key> keys(Key lo, Key hi){
        return null;
    }

    /* *
     *返回所有键,已排序
     *
     *@author wxq
     *@date 2019-4-19
     */
    public Iterable<Key> keys(){
        return keys(min(), max());
    }

}
