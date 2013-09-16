package be.kdg.concurrency;

import java.util.Random;

public class BowRunnable implements Runnable {
    private static Random random = new Random();
    private static int count = 0;
    private Friend first;
    private Friend second;

    public BowRunnable(Friend first, Friend second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        while(count++ < 100) {
           try {
              Thread.sleep(random.nextInt(10));
           } catch (InterruptedException e) {
             // leeg ?
           }
           first.bow(second);
        }
    }
}
