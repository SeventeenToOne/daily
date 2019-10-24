package bishi.zoom;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-09-29 16:37
 **/
class Base{}
class SubClass1 extends Base{}
class SubClass2 extends Base{}
public class Demo{
    public static void main(String[] args) {
        Base b = new Base();
        SubClass1 s1 = new SubClass1();
        s1 = (SubClass1)null;
        SubClass1 s2 = new SubClass1();
        s1 = (SubClass1)s2;
    }
}

//class Base{
//    public Base(int i){
//
//    }
//}
//public class Demo extends Base{
//    public Demo(int i) {
//        super(i);
//    }
//
//    public static void main(String[] args) {
//        Demo demo = new Demo(1);
//    }
//
//    Demo(String str, int i){
//        this(i);
//        Base base = new Base(1);
//    }
//}
