package ThinkInJava.泛型;

import ThinkInJava.泛型.util.Generator;
import ThinkInJava.泛型.util.Generators;

import java.util.*;
/*
* 匿名类内部类实现Generator接口
* P369
*
* @author wxq
* @date 2018-4-20
* */
class Customer{
    private static long counter = 1;
    private final long id = counter++;

    private Customer(){

    }

    public String toString(){
        return "Customer " + id;
    }

     public static Generator<Customer>  generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
     }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller(){

    }
    public String toString(){
        return "Teller " + id;
    }
    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}


public class BankTeller {
    public static void serve(Teller t, Customer c){
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args){
        Random random = new Random();
        Queue<Customer> customers = new LinkedList<>();
        Generators.fill(customers, Customer.generator(), 16);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer customer : customers) {
            serve(tellers.get(random.nextInt(tellers.size())), customer);
        }

    }
}
