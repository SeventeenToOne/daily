package bishi.yuncong2019;

import javafx.beans.binding.ObjectExpression;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static int i = 1;
    public static volatile boolean stop = false;
    public static boolean[] runFalg;
    public static int threadSize;
    public static final Object lock = new Object();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] ids = str.split(",");

        threadSize = ids.length;

        runFalg = new boolean[ids.length+1];
        Thread[] ts = new Thread[ids.length+1];

        for (String id : ids) {
            PrintNum printNum = new PrintNum(Integer.valueOf(id));
            ts[i] = new Thread(printNum);
            ts[i].start();
        }

        runFalg[1] = true;




    }
}

class PrintNum implements Runnable{
    private int id;



    public PrintNum(int id){
        this.id = id;

    }

    @Override
    public void run() {
        synchronized (Main.lock){
            try {
                while(Main.i < 100 && !Main.stop){

                    while (!Main.runFalg[id]){
                        Main.lock.wait();
                    }

                    if(Main.stop){
                        Main.lock.notifyAll();
                        System.out.println("break : " + id);
                        break;
                    }

                    for (int j = 0; j < 5; j++){
                        if(Main.i <= 75){
                            System.out.println("thread"+ id + ":" + Main.i);
                            Main.i++;
                        }else {
                            Main.stop = true;

                        }

                    }

                    int next = id >= Main.threadSize ? 1 : id + 1;

                    Main.runFalg[id] = false;
                    Main.runFalg[next] = true;

                    Main.lock.notifyAll();

                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

/*
1,2,3

1,2,3,4,5
* */


