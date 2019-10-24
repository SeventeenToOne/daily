package ThinkInJava.Concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @program: algorithms
 * @description: P725 ThinkInJava
 * @author: wxq
 * @date 2018-09-11 20:26
 **/
class Horse implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier cyclicBarrier ;

    public Horse(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                synchronized (this){
                    strides += rand.nextInt(3);
                }
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public int getStrides() {
        return strides;
    }

    public String tracks(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            stringBuilder.append("*");
        }
        return stringBuilder.toString();
    }
}

public class HorseRace {
    static final int FINISH_LINE = 75 ;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;

    public HorseRace(int nHorses, final int parse){
        cyclicBarrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    s.append("=");
                }
                System.out.println(s);
                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }
                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + " win ");
                        executorService.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(parse);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 200;
        new HorseRace(nHorse, pause);
    }
}
