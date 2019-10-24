package ThinkInJava.Arrays;

import ThinkInJava.泛型.util.Generator;
import com.sun.org.apache.xpath.internal.operations.String;

import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: algorithms
 * @description: P444
 * @author: wxq
 * @date 2018-07-04 15:18
 **/
public class GeneratorTest {

    public static int size = 10;

    public static void test(Class<?> surroundClass){
        for (Class<?> type : surroundClass.getClasses()) {
            System.out.println(type.getSimpleName());
            try {
                Generator<?> gen = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(gen.next() + " ");
                }
                System.out.println();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args){
//        test(CountingGenerator.class);
//        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
//        byte[] bytes = new byte[1] ;
//        bytes[0] = 1;
//        String string = new String(bytes, "12");

    }
}
