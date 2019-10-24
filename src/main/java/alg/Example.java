package alg;

import ThinkInJava.泛型.util.Generator;

import java.util.Random;

public class Example implements Comparable<Example> {
    private int value;

    public Example(){

    }

    public Example(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Example example = (Example) o;

        return value == example.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(Example o) {
        if(this.value == o.value){
            return 0;
        }else if (this.value < o.value){
            return -1;
        }else {
            return 1;
        }

    }

    // 通过生成器生成类
    public static Generator<Example> generator(){
        return new Generator<Example>() {
            @Override
            public Example next() {
                Random random = new Random();
                return new Example(random.nextInt(2));
            }
        };
    }

}
