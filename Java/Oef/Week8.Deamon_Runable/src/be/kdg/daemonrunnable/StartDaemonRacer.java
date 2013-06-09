package be.kdg.daemonrunnable;

import java.util.Scanner;

public class StartDaemonRacer {
    public static void main(String[] args) {
    	DaemonRunnableRacer een = new DaemonRunnableRacer("een");
    	Thread DraadEen = new Thread(een);
    	DaemonRunnableRacer twee = new DaemonRunnableRacer("twee");
    	Thread DraadTwee = new Thread(twee);
    	
    	DraadEen.setDaemon(true);
    	DraadTwee.setDaemon(true);
    	
    	DraadEen.start();
    	DraadTwee.start();
    	
    	System.out.println("Druk op <ENTER> om te stoppen...");
        new Scanner(System.in).nextLine();

        System.out.printf("%s legde %d ronden af.%n", een.getNaam(), een.getRondeNummer());
        System.out.printf("%s legde %d ronden af.%n", twee.getNaam(), twee.getRondeNummer());
    }
}