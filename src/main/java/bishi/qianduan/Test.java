package bishi.qianduan;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-09-09 19:27
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("A");
        System.out.println("Test");
        clazz.forName("A");

    }
}

class A{
    static {
        System.out.println("A");
    }
}

//public class Test {
//    public static void main(String[] args) throws Exception {
//        System.out.println(B.c);
//    }
//}
//
//class A{
//    static {
//        System.out.println("A");
//    }
//}
//
//class B extends A{
//    static {
//        System.out.println("B");
//    }
//
//    public final static String c= "C";
//}

//public class Test {
//    public static void main(String[] args) throws Exception {
//        System.out.println("A");
//        new Test();
//        new Test();
//    }
//
//    public Test(){
//        System.out.println("B");
//    }
//    {
//        System.out.println("C");
//    }
//    static {
//        System.out.println("D");
//    }
//}