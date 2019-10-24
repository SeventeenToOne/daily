package ThinkInJava.Arrays;

import ThinkInJava.泛型.util.Generator;

/**
 * @program: algorithms
 * @description: 数据生成器
 * @author: wxq
 * @date 2018-07-04 15:01
 **/
public class CountingGenerator {

    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;

        public  java.lang.Boolean next(){
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private java.lang.Byte value = 0;
        @Override
        public java.lang.Byte next(){
            return value++;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private static int value = 0;
        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }


    // P445

}
