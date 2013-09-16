package be.kdg.daemon;

import java.util.Random;

public class DaemonRacer extends Thread {
    private static final Random random = new Random();
    private String naam;
    private int rondeNummer;

    public DaemonRacer(String naam) {
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
                sleep(random.nextInt(100));
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

