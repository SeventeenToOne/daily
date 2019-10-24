package bishi.kaluli;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-08-23 19:03
 **/
public class Main {
    static int func(int x){
        int count = 0;
        while (x > 0){
            count++;
            x = x & (x - 1);
        }
        return count;
    }
    public static void main(String[] args) {


        System.out.println(func(99999));
    }
}
