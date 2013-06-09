package be.kdg.democounter;

public class DecrementRunnable implements Runnable {
    private Counter counter;

    public DecrementRunnable(Counter counter) {
        this.counter = counter;
     }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.decrement();
        }
    }
}
