package alg;

import javax.swing.*;
import java.security.Key;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-09 14:03
 **/
public class test extends B{
    public void say(){
        System.out.println("aa");
    }

    public static void main(String[] args) {
        A<Integer> a = new B();
        a.say(3);
    }
}

class A <Key extends Comparable<Key>>{
    public void say(Key key){
        System.out.println(key + " A");
    }
}


class B<Key extends A> extends A{
    public void say(Key key){
        System.out.println("b");
    }

}