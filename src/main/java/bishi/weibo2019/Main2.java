package bishi.weibo2019;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main2 {
    Stack<Integer> s;
    Map<Integer, Integer> m;
    int count;


    public Main2(int capacity) {
        s = new Stack<>();
        m = new HashMap<>();
        count =capacity;

    }

    public int get(int key) {
        if(!s.contains(key)){
            return -1;
        }

        Integer value = Integer.valueOf(key);

        s.remove(value);
        s.push(key);
        return m.get(key);


    }

    public void put(int key, int value) {
        int num;
        if(s.contains(key)){
            Integer keyInterger = Integer.valueOf(key);
            s.remove(keyInterger);
        }else {
            if(s.size() == count){
                num = s.remove(0);
                m.remove(num);
            }
        }
        s.push(key);
        m.put(key, value);

    }


}
