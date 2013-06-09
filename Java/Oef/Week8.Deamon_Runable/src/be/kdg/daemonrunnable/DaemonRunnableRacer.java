package be.kdg.daemonrunnable;

import java.util.Random;

public class DaemonRunnableRacer implements Runnable {
    private static final Random random = new Random();
    private String naam;
    private int rondeNummer;

    public DaemonRunnableRacer(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public int getRondeNummer() {
        return rondeNummer;
    }

    public void run() {
        System.out.println(naam + " START");
        while (true) {
            rondeNummer++;
            try {
                Thread.sleep(random.nextInt(100));
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

