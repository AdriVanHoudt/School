package be.kdg.deadlock;

public class Start {
    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        Thread first = new Thread(new BowRunnable(alphonse, gaston));
        Thread second = new Thread(new BowRunnable(gaston, alphonse));

        first.start();
        second.start();
    }
}
