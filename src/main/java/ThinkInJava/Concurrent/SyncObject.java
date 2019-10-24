package ThinkInJava.Concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * @program: algorithms
 * @description: P690 不同的锁上的同步
 * @author: wxq
 * @date 2018-08-31 14:44
 **/

class DualSynch{
    private Object syncObject = new Object();
    public synchronized void f(){
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g(){
        synchronized (syncObject){
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
public class SyncObject {
    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();
        new Thread(){
            public void run(){
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
}
