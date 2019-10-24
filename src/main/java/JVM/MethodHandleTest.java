package JVM;

/**
 * @program: algorithms
 * @description: jvm P262
 * @author: wxq
 * @date 2019-04-26 20:47
 **/
public class MethodHandleTest {
    static class ClassA{
        public  void println(String s){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
         new ClassA().println("ss");
    }
}
