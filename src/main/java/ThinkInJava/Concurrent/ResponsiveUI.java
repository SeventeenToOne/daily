package ThinkInJava.Concurrent;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @program: algorithms
 * @description: P671 并发
 * @author: wxq
 * @date 2018-08-30 10:08
 **/
public class ResponsiveUI extends Thread {
    private volatile static double d = 1;

    public ResponsiveUI(){
        setDaemon(true);
        start();
    }

    public void run(){
        while (true){
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {

        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
