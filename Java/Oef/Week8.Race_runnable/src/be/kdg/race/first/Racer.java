package be.kdg.race.first;

import java.util.Random;

public class Racer implements Runnable {
    private static final Random random = new Random();

    public void run() {
        Thread theThread = Thread.currentThread();

        System.out.println(theThread.getName() + " START");
        for (int i = 0; i < 10; i++) {
            System.out.println(theThread.getName() + " ronde " + (i + 1));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                // negeer
            }
        }
        System.out.println(theThread.getName() + " AANGEKOMEN");
    }
}


