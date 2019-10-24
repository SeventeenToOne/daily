package ThinkInJava.Concurrent;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: algorithms
 * @description: P730 温室控制器 调用ScheduledExecutor
 * @author: wxq
 * @date 2018-09-25 20:10
 **/
public class GreenHouseScheduler {
//    　一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
//     1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
//     2）禁止进行指令重排序。
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public synchronized String getThermostat(){
        return thermostat;
    }
    public synchronized void setThermostat(String value){
        thermostat = value;
    }
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
    // 对schedule进行包装
    public void schedule(Runnable task, long delay){
        scheduledThreadPoolExecutor.schedule(task, delay, TimeUnit.MILLISECONDS);
    }
    // 对scheduleAtFixed进行封装
    public void repeat(Runnable task, long initialDelay, long period){
        scheduledThreadPoolExecutor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    class LightOn implements Runnable{

        @Override
        public void run() {
            System.out.println("Turning on lights " + light);
            light = true;
        }
    }

    class LightOff implements Runnable{

        @Override
        public void run() {
            System.out.println("Turning off lights " + light);
            light = false;
        }
    }

    class WaterOn implements Runnable {

        @Override
        public void run() {
            System.out.println("Turning greenhourse water on " + water);
            water = true;
        }
    }

    class WaterOff implements Runnable{

        @Override
        public void run() {
            System.out.println("Turing greehourse water off " + water);
            water = false;
        }
    }

    class ThermostatNight implements Runnable{

        @Override
        public void run() {
            System.out.println("Thermostat to night setting " + getThermostat());
            setThermostat("night");
        }
    }

    class ThermostatDay implements Runnable{

        @Override
        public void run() {
            System.out.println("thermostat to day setting " + getThermostat());
            setThermostat("Day");
        }
    }

    class Bell implements Runnable{

        @Override
        public void run() {
            System.out.println("Bing");
        }
    }

    class Terminate implements Runnable{

        @Override
        public void run() {
            System.out.println("Terminating");
            scheduledThreadPoolExecutor.shutdownNow();
            new Thread(){
                @Override
                public void run() {
                    //
                    for (DataPoint datum : data) {
                        System.out.println(datum);
                    }

                }
            }.start();
        }
    }
    // data collection
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;
        public DataPoint(Calendar d, float temp, float hum){
            time = d;
            temperature = temp;
            humidity = hum;
        }

        @Override
        public String toString() {
            return time.getTime() + String.format(" temperate : %.1f humidity: %2$.2f", temperature, humidity);
        }

    }
    private Calendar lastTime = Calendar.getInstance();
    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);

    List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());

    class CollectionData implements Runnable{

        @Override
        public void run() {
            System.out.println("Collection Data");
            synchronized (GreenHouseScheduler.this){
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE)+30);
                if (rand.nextInt(5) == 4){
                    tempDirection = -tempDirection;
                }
                lastTemp = lastTemp + tempDirection*(1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4){
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }

    public static void main(String[] args) {
        GreenHouseScheduler gh = new GreenHouseScheduler();
        gh.schedule(gh.new Terminate(), 5000);
        gh.repeat(gh.new Bell() , 0, 1000);
        gh.repeat(gh.new ThermostatNight() , 0, 2000);
        gh.repeat(gh.new LightOn() , 0, 200);
        gh.repeat(gh.new LightOff() , 0, 400);
        gh.repeat(gh.new WaterOn() , 0, 600);
        gh.repeat(gh.new WaterOff() , 0, 800);
        gh.repeat(gh.new ThermostatDay() , 0, 1400);
        gh.repeat(gh.new CollectionData() , 500, 500);
    }

}
