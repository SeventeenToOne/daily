package bishi.qianduan;

import java.util.Scanner;


//public class Main {
//    public static void main(String[] args) {
//        System.out.println(Test2.a);
//    }
//
//}
//
//class Test2{
//    public static final String a = "JD";
//
//    static {
//        System.out.println("OK");
//    }
//}

//public class Main {
//    public static void main(String[] args) throws ClassNotFoundException {
//       ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//       Class clazz = classLoader.loadClass("A");
//        System.out.println("Test");
//        clazz.forName("A");
//
//    }
//
//}

//class A{
//    static {
//        System.out.println("A");
//    }
//}


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(B.c);
    }
}

class A1{
    public static String c = "C";
    static {
        System.out.println("A");
    }
}

class B extends A1{
    static {
        System.out.println("B");
    }
}