package be.kdg.race.second;

import java.util.Random;

public class Racer extends Thread {  // Let op de extends!
    private static final Random random = new Random();
    private String naam;

    public Racer(String naam) {
       this.naam = naam;
    }

    public void run() {

        System.out.println(this.naam + " START");
        for (int i = 0; i < 10; i++) {
            System.out.println(this.naam + " ronde " + (i + 1));
            try {
                sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                // negeer
            }
        }
        System.out.println(this.naam + " AANGEKOMEN");
    }

}
