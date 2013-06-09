package be.kdg.democounter;

public class IncrementRunnable implements Runnable {
    private Counter counter;

    public IncrementRunnable(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
