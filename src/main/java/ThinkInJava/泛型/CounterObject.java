package ThinkInJava.泛型;

public class CounterObject {
    private static long counter = 0;
    private final long id = counter++;
    public CounterObject(){

    }
    public long id(){
        return id;
    }

    public String toString(){
        return "CountedObject " + id;
    }
}
