package bishi.youzan2019;

public class Test{
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        System.out.println("Result=" + a.func1(100, 50));
        System.out.println("Result=" + b.func1(100, 50));
    }
}

class A{
    public int func1(int a, int b){
        return a - b;
    }
}

class B extends A{
    public int func1(int a, int b){
        return a + b;
    }
}