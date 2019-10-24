package bishi;

import java.util.*;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-08-01 19:47
 **/
public class HUWEI_2gai {
    public static void main(String[] args){
//        String str = "ABAACCADDDAAA";
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Map<Integer, Character> res = new HashMap<>();
        int max = 1;
        char t = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if(t == str.charAt(i)){
                max++;
            }else {
                if(res.containsKey(max) && res.get(max) < t){

                }else {
                    res.put(max, t);
                }
                max = 1;
                t = str.charAt(i);
            }
        }
        if(res.containsKey(max) && res.get(max) < t){

        }else {
            res.put(max, t);
        }

        Set<Integer> set =  res.keySet();
        max = 0;
        for (Integer integer : set) {
            if(max < integer){
                max = integer;
            }
        }
        char c = res.get(max);
        for (int i = 0; i < max; i++) {
            System.out.print(c);
        }
        System.out.println();
    }
}
