package ThinkInJava;



public class Generic {
    public static void main(String[] args){
        String a, b;
        TwoTuple<String, TestObject> twoTuple = new TwoTuple<>("a", new TestObject());
        System.out.println(twoTuple.toString());
        twoTuple.second.setValue(2);

    }
}

class TwoTuple<A, B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b){
        this.first = a;
        this.second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class TestObject{
    private int value = 3;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
