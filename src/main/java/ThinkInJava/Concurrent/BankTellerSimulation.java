package ThinkInJava.Concurrent;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: algorithms
 * @description: P739 银行柜员仿真
 * @author: wxq
 * @date 2018-09-26 20:35
 **/
class Customer{
    private final int serviceTime;
    public Customer(int sTime){
        serviceTime = sTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}

class CustomerLine extends ArrayBlockingQueue<Customer>{

    public CustomerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        if(this.size() == 0){
            return "[empty]";
        }
        StringBuilder result = new StringBuilder();
        for (Customer customer : this) {
            result.append(customer);
        }
        return result.toString();
    }
}

class CustomerGenerator implements Runnable{
    private CustomerLine customers;
    private Random rand = new Random(47);

    public CustomerGenerator(CustomerLine cline){
        customers = cline;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenerator interrupted");
            e.printStackTrace();
        }
        System.out.println("CustomerGenerator Teminating");

    }

}

class Teller implements Runnable, Comparable<Teller>{
    private static int count = 0;
    private final int id = count++;

    private CustomerLine customers;
    private boolean servingCustomerLine = true;
    private int customerServiced = 0;

    public Teller(CustomerLine cq){
        customers = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
               Customer customer = customers.take();
               TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
               synchronized (this){
                   customerServiced++;
                   while (!servingCustomerLine){
                       wait();
                   }
               }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Teller terminating ");
    }

    public synchronized void doSomethingElse(){
        servingCustomerLine = false;
    }


    public synchronized void servingCustomerLine(){
        servingCustomerLine = true;

    }

    @Override
    public String toString() {
        return "Teller " + id + " ";
    }
    public String shortString(){
        return "T" + id;
    }
    // 用作priorityqueue
    public synchronized int compareTo(Teller other){
        return Integer.compare(customerServiced, other.customerServiced);
    }

}

class TellerManager implements Runnable{
    private ExecutorService executorService;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTeller = new PriorityQueue<>();
    private PriorityQueue<Teller> tellerDoingOtherThing = new PriorityQueue<>();
    private int adjustmentPeriod;
    private Random random = new Random(47);

    public TellerManager(ExecutorService executorService, CustomerLine cq, int adjustmentPeriod){
        this.executorService = executorService;
        this.customers = cq;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller  teller = new Teller(customers);
        executorService.execute(teller);
        workingTeller.add(teller);
    }

    public void adjustTellerNumber(){
        if(customers.size() / workingTeller.size() > 2){
            if(tellerDoingOtherThing.size() > 0){
                Teller teller = tellerDoingOtherThing.remove();
                workingTeller.offer(teller);
                return;
            }
            Teller teller = new Teller(customers);
            executorService.execute(teller);
            workingTeller.add(teller);
            return;
        }

        if(workingTeller.size() > 1 && customers.size()/workingTeller.size() < 2){
            resignOneTeller();
        }
    }

    public void resignOneTeller(){
        Teller teller = workingTeller.poll();
        teller.doSomethingElse();
        tellerDoingOtherThing.offer(teller);
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.println(customers + "{");
                for (Teller teller : workingTeller) {
                    System.out.print(teller.shortString() + " ");
                }
                System.out.println("}");
            }
        }catch (InterruptedException e){
            System.out.println("TellerManager exception");
        }
        System.out.println("TellerManager teminating");
    }

    @Override
    public String toString() {
        return "TellerManager";
    }
}

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOF = 1000;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        executorService.execute(new CustomerGenerator(customers));
        executorService.execute(new TellerManager(executorService, customers, ADJUSTMENT_PERIOF));
        System.out.println("Press Enter to quie");
        System.in.read();
        executorService.shutdownNow();
    }

}
