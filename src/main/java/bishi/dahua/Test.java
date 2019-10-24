package bishi.dahua;

import java.util.Date;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-09-27 10:16
 **/
public class Test {
    public static void main(String[] args) {
        String str1 = "test";
        String str2 = "test";
        String str3 = new String("test");
        String str4 = new String("test");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str3 == str4);
        Date date = new Date();
        System.out.println(date.getMinutes());
    }
}
