package be.kdg.shared;

public class RunShared {
    public static void main(String[] args) {
        Show show = new Show();

        Share one = new Share("Thread 1: ", show);
        Share two = new Share("Thread 2: ", show);

        one.start();
        two.start();
    }
}
