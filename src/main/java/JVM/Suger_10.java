package JVM;

import edu.princeton.cs.algs4.In;

/**
 * @program: algorithms
 * @description: 自动装箱陷阱 P316
 * @author: wxq
 * @date 2019-05-05 19:39
 **/
public class Suger_10 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a+b));
        System.out.println(g == (a+b));
        System.out.println(g.equals((a + b)));

    }
}
