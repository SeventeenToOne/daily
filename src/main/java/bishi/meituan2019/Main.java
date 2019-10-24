package bishi.meituan2019;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if (n <= 0){
            return;
        }

        ReviewEncourage reviewEncourage = new ReviewEncourage(n);
        Bonus bonus = new Bonus(reviewEncourage);
        Contribution contribution = new Contribution(reviewEncourage);
        Coupon coupon = new Coupon(reviewEncourage);

        //Thread t1 = new Thread(bonus);

        Thread t2 = new Thread(contribution);

        Thread t3 = new Thread(coupon);

        //t1.start();
        t2.start();
        t3.start();

    }
}

class ReviewEncourage{
    volatile  int peopleNum;
    volatile  int index;
    PrizePool prizePool;
    volatile boolean IsB = true;
    volatile boolean isFinish = false;

    public ReviewEncourage(int n){
        peopleNum = n;
        index = 1;
        prizePool = new PrizePool();
    }

    public void bonus(PrizePool prizePool){
        prizePool.send("A");
    }
    public void coupon(PrizePool prizePool){
        prizePool.send("B");
    }
    public void contribution(PrizePool prizePool){
        prizePool.send("C");
    }
}

class PrizePool{
    public void send(String input){
        //没有回车
        System.out.print(input);
    }
}

class Bonus implements Runnable{
    final ReviewEncourage reviewEncourage;

    public Bonus(ReviewEncourage reviewEncourage){
        this.reviewEncourage = reviewEncourage;
    }

    @Override
    public void run() {
        synchronized (reviewEncourage){
            try {
                while(reviewEncourage.index <= reviewEncourage.peopleNum){

                    if (!reviewEncourage.isFinish && reviewEncourage.index % 2 == 0){
                        reviewEncourage.wait();
                    }else {
                        if(reviewEncourage.isFinish){
                            break;
                        }

                        reviewEncourage.bonus(reviewEncourage.prizePool);
                        reviewEncourage.index++;

                        if (reviewEncourage.index > reviewEncourage.peopleNum){
                            reviewEncourage.isFinish = true;
                        }

                        reviewEncourage.notifyAll();
                    }


                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Coupon implements Runnable{
    final ReviewEncourage reviewEncourage;

    public Coupon(ReviewEncourage reviewEncourage){
        this.reviewEncourage = reviewEncourage;
    }

    @Override
    public void run() {
        synchronized (reviewEncourage){
            try {
                while(reviewEncourage.index <= reviewEncourage.peopleNum){

                    if (!reviewEncourage.isFinish && reviewEncourage.index % 2 != 0 && reviewEncourage.IsB == false){
                        reviewEncourage.wait();
                    }else {
                        if(reviewEncourage.isFinish){
                            break;
                        }

                        reviewEncourage.coupon(reviewEncourage.prizePool);
                        reviewEncourage.index++;
                        reviewEncourage.IsB = false;

                        if (reviewEncourage.index > reviewEncourage.peopleNum){
                            reviewEncourage.isFinish = true;
                        }

                        reviewEncourage.notifyAll();
                    }


                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

class Contribution implements Runnable{
    final ReviewEncourage reviewEncourage;

    public Contribution(ReviewEncourage reviewEncourage){
        this.reviewEncourage = reviewEncourage;
    }

    @Override
    public void run() {
        synchronized (reviewEncourage){
            try {
                while(!reviewEncourage.isFinish && reviewEncourage.index <= reviewEncourage.peopleNum){

                    if (reviewEncourage.index % 2 != 0 && reviewEncourage.IsB == true){
                        reviewEncourage.wait();
                    }else {

                        if(reviewEncourage.isFinish){
                            break;
                        }

                        reviewEncourage.contribution(reviewEncourage.prizePool);
                        reviewEncourage.index++;
                        reviewEncourage.IsB = true;

                        if (reviewEncourage.index > reviewEncourage.peopleNum){
                            reviewEncourage.isFinish = true;
                        }

                        reviewEncourage.notifyAll();
                    }

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
