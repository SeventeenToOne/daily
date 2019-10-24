package Current;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-07-05 16:16
 **/
public class TestGetIsVisua {
    public static void main(String[] args) {
        Account a = new Account();
        GetThread get = new GetThread(a);
        SetThread set = new SetThread(a);
        Thread s = new Thread(set);
        Thread g = new Thread(get);
        s.start();
        g.start();

    }
}

class Account {
    private static Object lock = new Object();
    private final Value value;
    public Account(){
        this.value = new Value();
    }

    public synchronized void set(int value){
        this.value.value = value;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("set sleep");
//        try {
//            this.wait(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public int get(){
//        synchronized (lock){
//            return value.value;
//        }
        return value.value;

    }
}

class GetThread implements Runnable{
    Account a;
    public GetThread(Account a){
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("GetThread1: " + a.get());
        while (true){
            if (a.get() != 10){
                //当前线程永远不知道值会改变
                System.out.println("GetThread2: " + a.get());
                break;
            }

        }

    }

}

class SetThread implements Runnable{
    Account a;
    public SetThread(Account a){
        this.a = a;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.set(100);
        System.out.println("finish set");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("finish sleep");

    }
}

class Value{
    int value = 10;
}