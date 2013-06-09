package be.kdg.deadlock;

import java.util.Random;

public class BowRunnable implements Runnable {
    private static Random random = new Random();
    private Friend first;
    private Friend second;

    public BowRunnable(Friend first, Friend second) {
        this.first = first;
        this.second = second;
    }

    public void run() {
        while(true) {
           try {
              Thread.sleep(random.nextInt(10));
           } catch (InterruptedException e) {
             // leeg ?
           }
           first.bow(second);
        }
    }
}
