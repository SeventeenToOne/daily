package ThinkInJava.泛型;


import ThinkInJava.泛型.util.BasicGenerator;
import ThinkInJava.泛型.util.Generator;


public class BasicGeneratorDemo {
    public static void main(String[] args){
        Generator<CounterObject> gen = BasicGenerator.create(CounterObject.class);
        for (int i = 0; i < 5; i++){
            System.out.println(gen.next());
        }
    }
}
